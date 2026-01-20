# Payrexx Tap to Pay SDK - Android Developer Documentation

The **Payrexx Tap to Pay SDK** allows Android developers to integrate contactless payment functionalities directly into their applications. The SDK acts as a bridge, communicating with the **Payrexx Tap to Pay App** via secure Android Intents to perform sales, refunds, voids, and receipt management.

## Table of Contents

1. [Requirements](#1-requirements)
2. [Installation](#2-installation)
3. [Getting Started](#3-getting-started)
4. [Operations](#4-operations)
    - [Sale (Payment)](#41-sale)
    - [Refund](#42-refund)
    - [Void](#43-void)
    - [Receipts](#44-receipts)
    - [Transaction History](#45-transaction-history)
5. [Handling Responses](#5-handling-responses)
6. [Data Models & Fields](#6-data-models--fields)
    - [Date Handling](#date-handling)
7. [Error Handling](#7-error-handling)
8. [Sample Project](#8-sample-project)

---

## 1. Requirements

Before integrating the SDK, ensure your development environment meets the following criteria:

* **Android SDK:** Minimum API Level 26 (Android 8.0) or higher.
* **Hardware:** An Android device with **NFC** capabilities.
* **External Dependency:** The device **must** have the **Payrexx Tap to Pay App** installed (Package: `com.payrexx.taptopay.SOFTPOS`). This SDK relies on it to process the raw NFC data securely.

## 2. Installation

Add the SDK library to your project.

*(Note: Replace the instructions below with your specific distribution method, e.g., Maven, JitPack, or local .aar import).*

```gradle
// build.gradle (app module)
dependencies {
    implementation("io.github.payrexx:taptopay-sdk:1.0.0")
}
```

## 3. Getting Started

The core entry point for the SDK is the `TapToPay` class.

### Initialization
You must initialize `TapToPay` inside a `FragmentActivity` (or `AppCompatActivity`). The SDK requires access to the `FragmentManager` to handle result callbacks.

```java
import io.github.payrexx.taptopay.sdk.TapToPay;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TapToPay tapToPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the SDK
        tapToPay = new TapToPay(this);
    }
}
```

---

## 4. Operations

All interactions with the **Payrexx Tap to Pay App** are defined as **Operations**. To perform an action:
1.  Create the specific **DTO** (Data Transfer Object).
2.  Instantiate the **Operation** class with that DTO.
3.  Call `tapToPay.doOperation()`.

### 4.1 Sale

Initiate a standard purchase transaction. If the `paymentMethod` is not specified, the **Payrexx Tap to Pay App** will display a chooser for the user to select their preferred method.

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `amount` | `float` | The transaction amount. |
| `tip` | `float` | The tip amount (set to `0` if none). |
| `orderReference` | `String` | Unique reference for your internal tracking. |
| `paymentMethod` | `PaymentMethod` | *(Optional)* Pre-select a payment method (e.g., `CARD`, `TWINT`). If omitted, a chooser is shown in the app. |
| `showResult` | `boolean` | *(Optional)* Whether the Tap to Pay app shows the result screen. |

```java
import io.github.payrexx.taptopay.sdk.dto.SaleDto;
import io.github.payrexx.taptopay.sdk.lib.operation.Sale;
import io.github.payrexx.taptopay.sdk.model.transaction.PaymentMethod;

// 1. Prepare Data
// Option A: Without pre-selecting a payment method (shows chooser in app)
SaleDto saleDto = new SaleDto(25.00f, 0.00f, "ORDER-1001");

// Option B: With pre-selected payment method (e.g., skip the chooser)
// SaleDto saleDto = new SaleDto(25.00f, 0.00f, PaymentMethod.CARD, "ORDER-1001");

// Optional: saleDto.showResult = true;

// 2. Create Operation
Sale sale = new Sale(saleDto);

// 3. Execute
tapToPay.doOperation(sale, response -> {
    // Handle result (See Section 5)
});
```

### 4.2 Refund

Refund a previously successful transaction.

**Important:** Before attempting a refund, you should verify the `refundableAmount` on the original transaction object. This field indicates the remaining amount available for refund (handling cases of partial refunds).

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `transactionId` | `String` | The unique ID of the original transaction. |
| `amount` | `float` | The amount to be refunded. |

```java
import android.util.Log;
import io.github.payrexx.taptopay.sdk.dto.RefundDto;
import io.github.payrexx.taptopay.sdk.lib.operation.Refund;
import io.github.payrexx.taptopay.sdk.model.Transaction;

// Assume 'originalTransaction' is available from History or a previous response
float amountToRefund = 5.00f;

if (originalTransaction.refundableAmount != null && 
    originalTransaction.refundableAmount >= amountToRefund) {

    RefundDto refundDto = new RefundDto(originalTransaction.id, amountToRefund);
    Refund refund = new Refund(refundDto);

    tapToPay.doOperation(refund, response -> { /* Handle result */ });

} else {
    Log.e("TapToPay", "Insufficient funds remaining for this refund.");
}
```

### 4.3 Void

Cancel a transaction. A Void is typically only possible before the transaction has been settled (e.g., same-day).

**Restrictions:**
1.  **Full Amount Only:** Voids are strictly "all-or-nothing". You cannot void a partial amount. For partial returns, use [Refund](#42-refund).
2.  **Credit Card Only:** You can only void transactions where the `paymentMethod` was `CARD`. Other methods (like TWINT) are not supported for Void operations.

**Important:** Before attempting a void, you should verify if the transaction is eligible by checking the `voidable` field on the `Transaction` object.

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `transactionId` | `String` | The unique ID of the transaction to void. |

```java
import android.util.Log;
import io.github.payrexx.taptopay.sdk.dto.VoidDto;
import io.github.payrexx.taptopay.sdk.lib.operation.Void;
import io.github.payrexx.taptopay.sdk.model.Transaction;
import io.github.payrexx.taptopay.sdk.model.transaction.PaymentMethod;

// Check 1: Is it voidable?
// Check 2: Is it a Credit Card?
if (originalTransaction.voidable && originalTransaction.paymentMethod == PaymentMethod.CARD) {
    
    VoidDto voidDto = new VoidDto(originalTransaction.id);
    Void voidOp = new Void(voidDto);

    tapToPay.doOperation(voidOp, response -> { 
        // Handle result
    });

} else {
    Log.w("TapToPay", "Transaction cannot be voided (Check settlement status or payment method).");
}
```

### 4.4 Receipts

Send a receipt for a specific transaction via **email** or **SMS**.

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `transactionId` | `String` | The unique ID of the transaction. |
| `type` | `String` | Must be either `"email"` or `"sms"`. |
| `recipient` | `String` | The email address or mobile number. |

**Formatting Requirement for SMS:**
If the type is `"sms"`, the recipient number **must** be in the international format starting with `+`.
* **Correct:** `+41791234567`
* **Incorrect:** `0791234567`

```java
import io.github.payrexx.taptopay.sdk.dto.ReceiptDto;
import io.github.payrexx.taptopay.sdk.lib.operation.Receipt;

// Example 1: Email Receipt
ReceiptDto emailReceipt = new ReceiptDto("transaction_uuid_123", "email", "customer@example.com");

// Example 2: SMS Receipt (Note the international format)
ReceiptDto smsReceipt = new ReceiptDto("transaction_uuid_123", "sms", "+41791234567");

Receipt receiptOp = new Receipt(emailReceipt); // or smsReceipt

tapToPay.doOperation(receiptOp, response -> { 
    // Handle result
});
```

### 4.5 Transaction History

Retrieve a list of past transactions. You can initialize the `TransactionHistoryDto` in three different ways.

#### Option 1: Pagination Only
Retrieve the most recent transactions.
```java
// Page 1, 10 items per page
TransactionHistoryDto historyDto = new TransactionHistoryDto(1, 10);
```

#### Option 2: Search by Order Reference
Find a specific transaction by its merchant order reference.
```java
// Search for a specific order reference
TransactionHistoryDto historyDto = new TransactionHistoryDto("ORDER-REF-1001");
```

#### Option 3: Pagination with Filters
Retrieve transactions filtered by **Operation** and **Status** Enums.

```java
import io.github.payrexx.taptopay.sdk.lib.operation.TransactionHistory;
import io.github.payrexx.taptopay.sdk.model.transaction.Operation;
import io.github.payrexx.taptopay.sdk.model.transaction.Status;

// Filter: Only "Sales" that were "Successful"
TransactionHistoryDto historyDto = new TransactionHistoryDto(
    1, 
    10, 
    Operation.SALE,       // Filter by Operation Type
    Status.SUCCESSFUL     // Filter by Status
);

TransactionHistory history = new TransactionHistory(historyDto);

tapToPay.doOperation(history, response -> {
    // Returns a ListResponse
});
```

---

## 5. Handling Responses

The `TapToPayResultListener` returns a generic `Response` object. You must check the instance type to cast it correctly.

### Response Types

1.  **`SingleResponse`**: Returned by Sale, Void, Refund, Receipt. Contains a single `Transaction` object.
2.  **`ListResponse`**: Returned by TransactionHistory. Contains a list of `Transaction` objects.
3.  **`EmptyResponse`**: Returned if the operation was cancelled or returned no data.

### Implementation Example

```java
import android.util.Log;
import io.github.payrexx.taptopay.sdk.model.Response;
import io.github.payrexx.taptopay.sdk.model.SingleResponse;
import io.github.payrexx.taptopay.sdk.model.ListResponse;
import io.github.payrexx.taptopay.sdk.model.EmptyResponse;
import io.github.payrexx.taptopay.sdk.model.Transaction;

private static final String TAG = "TapToPayResult";

tapToPay.doOperation(operation, new TapToPayResultListener() {
    @Override
    public void onTapToPayResultCallback(Response response) {
        
        if (response instanceof SingleResponse) {
            SingleResponse result = (SingleResponse) response;
            if (result.transaction != null) {
                // Access transaction details
                String status = result.transaction.status.name(); // SUCCESSFUL, PENDING, FAILED
                String id = result.transaction.id;
                Log.d(TAG, "Transaction " + id + " was " + status);
            } else {
                // Handle logic error
                Log.e(TAG, "Error: " + result.message);
            }
            
        } else if (response instanceof ListResponse) {
            ListResponse listResult = (ListResponse) response;
            for (Transaction t : listResult.items) {
                // Process history items
                Log.d(TAG, "History Item: " + t.id + " - " + t.amount + " " + t.currency);
            }
            
        } else if (response instanceof EmptyResponse) {
            // User likely pressed back or cancelled
            Log.w(TAG, "Operation cancelled or no result returned.");
        }
    }
});
```

---

## 6. Data Models & Fields

The `Transaction` object contains comprehensive details about the payment. Below is the full list of fields available in the object.

| Field Name | Type | Description |
| :--- | :--- | :--- |
| `id` | `String` | The unique Transaction Key/ID (mapped from `transaction_key`). |
| `orderReference` | `String` | The merchant reference ID provided during the sale. |
| `amount` | `Float` | The total transaction amount. |
| `currency` | `String` | The currency code (e.g., CHF, EUR). |
| `status` | `Status` | Enum: `SUCCESSFUL`, `PENDING`, `FAILED`. |
| `responseCode` | `ResponseCode` | Enum: Detailed code from the processor (e.g., `SUCCESS`, `INSUFFICIENT_FUNDS`). |
| `operation` | `Operation` | Enum: `SALE`, `VOID`, `REFUND`. |
| `paymentMethod` | `PaymentMethod` | Enum: `CARD`, `TWINT`. |
| `cardType` | `String` | The card brand (e.g., "Visa", "Mastercard"). |
| `date` | `String` | Date and time of the transaction (ISO format). |
| `tipAmount` | `Float` | The amount designated as a tip. |
| `voidable` | `Boolean` | **Crucial:** Indicates if the transaction can currently be voided (Full amount only). |
| `refundableAmount` | `Float` | **Crucial:** The remaining amount available to be refunded. |
| `stan` | `String` | System Trace Audit Number (unique trace number per transaction). |
| `applicationId` | `String` | The AID (Application Identifier) of the card applet. |

### Date Handling

The SDK provides a static `DateTimeFormatter` helper inside the `Transaction` class to parse the date string returned by the Payrexx Tap to Pay App.

```java
import io.github.payrexx.taptopay.sdk.model.Transaction;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 1. Parse the String to LocalDateTime
LocalDateTime dateTime = LocalDateTime.parse(transaction.date, Transaction.dateTimeFormatter);

// 2. Format LocalDateTime to a readable String (e.g., for UI display)
DateTimeFormatter uiFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
String formattedDate = dateTime.format(uiFormatter);

Log.d("TapToPay", "Transaction Date: " + formattedDate);
```

---

## 7. Error Handling

When a transaction fails, check the `responseCode` inside the `Transaction` object for specific details.

### Common Response Codes
| Code | Enum Name | Meaning |
| :--- | :--- | :--- |
| `0` | `SUCCESS` | Transaction approved. |
| `51` | `INSUFFICIENT_FUNDS` | Card has insufficient funds. |
| `33` | `CARD_EXPIRED` | The card is expired. |
| `60` | `PIN_IS_REQUIRED` | Terminal requires PIN entry. |
| `80` | `NETWORK_ERROR` | Connection failed. |
| `3000` | `CANCELLED` | User cancelled the process. |

---

## 8. Sample Project

To see a complete implementation of this SDK in a working Android application, please refer to our sample project:

[**View Sample Project**](https://github.com/payrexx/TapToPayECRDemo)

The sample project demonstrates:
1.  SDK Initialization.
2.  Building a UI for inputting amounts.
3.  Handling the full lifecycle of a payment.
4.  Displaying the result to the user.
