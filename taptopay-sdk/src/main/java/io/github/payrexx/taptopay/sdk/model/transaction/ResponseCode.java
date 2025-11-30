package io.github.payrexx.taptopay.sdk.model.transaction;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the response code of a transaction.
 */
public enum ResponseCode {
    /**
     * Unknown response code.
     */
    @SerializedName("-1")
    UNKNOWN,
    /**
     * The transaction was successful.
     */
    @SerializedName("0")
    SUCCESS,
    /**
     * Refer to the card issuer.
     */
    @SerializedName(value="1", alternate = {"2", "8"})
    REFER_TO_CARD_ISSUER,
    /**
     * The merchant number is invalid.
     */
    @SerializedName("3")
    INVALID_MERCHANT_NUMBER,
    /**
     * The card should be retained.
     */
    @SerializedName(value = "4", alternate = {"7", "34", "37", "66", "67"})
    RETAIN_CARD,
    /**
     * Do not honor the transaction.
     */
    @SerializedName("5")
    DO_NOT_HONOR,
    /**
     * A system error occurred.
     */
    @SerializedName(value = "6", alternate = {"30", "79", "96", "97", "98", "99"})
    SYSTEM_ERROR,
    /**
     * Please wait.
     */
    @SerializedName("9")
    PLEASE_WAIT,
    /**
     * The transaction was partially approved.
     */
    @SerializedName("10")
    PARTIAL_APPROVAL,
    /**
     * The transaction is invalid.
     */
    @SerializedName("12")
    INVALID_TRANSACTION,
    /**
     * The amount is invalid.
     */
    @SerializedName("13")
    INVALID_AMOUNT,
    /**
     * The card is invalid.
     */
    @SerializedName("14")
    INVALID_CARD,
    /**
     * Unable to route to the issuer.
     */
    @SerializedName("15")
    UNABLE_TO_ROUTE_TO_ISSUER,
    /**
     * No action was taken.
     */
    @SerializedName("21")
    NO_ACTION_TAKEN,
    /**
     * Unable to locate the record on file.
     */
    @SerializedName("25")
    UNABLE_TO_LOCATE_RECORD_ON_FILE,
    /**
     * The file is not accessible.
     */
    @SerializedName("28")
    THE_FILE_IS_NOT_ACCESSIBLE,
    /**
     * A format error occurred.
     */
    @SerializedName("31")
    FORMAT_ERROR,
    /**
     * The card has expired.
     */
    @SerializedName(value = "33", alternate = {"54"})
    CARD_EXPIRED,
    /**
     * The card is restricted.
     */
    @SerializedName(value = "36", alternate = {"62"})
    RESTRICTED_CARD,
    /**
     * The PIN entry tries have been exceeded.
     */
    @SerializedName(value = "38", alternate = {"75"})
    PIN_ENTRY_TRIES_EXCEEDED,
    /**
     * The function is not supported.
     */
    @SerializedName("40")
    FUNCTION_NOT_SUPPORTED,
    /**
     * The card has been reported as lost.
     */
    @SerializedName("41")
    CARD_REPORTED_AS_LOST,
    /**
     * The card has been reported as stolen.
     */
    @SerializedName("43")
    CARD_REPORTED_AS_STOLEN,
    /**
     * Insufficient funds.
     */
    @SerializedName("51")
    INSUFFICIENT_FUNDS,
    /**
     * No checking account.
     */
    @SerializedName("52")
    NO_CHECKING_ACCOUNT,
    /**
     * No savings account.
     */
    @SerializedName("53")
    NO_SAVINGS_ACCOUNT,
    /**
     * The PIN is incorrect.
     */
    @SerializedName(value = "55", alternate = {"76"})
    INCORRECT_PIN,
    /**
     * The card is unknown.
     */
    @SerializedName("56")
    UNKNOWN_CARD,
    /**
     * The original transaction was not found.
     */
    @SerializedName("57")
    ORIGINAL_TRANSACTION_NOT_FOUND,
    /**
     * The terminal is unknown.
     */
    @SerializedName("58")
    UNKNOWN_TERMINAL,
    /**
     * A PIN is required.
     */
    @SerializedName("60")
    PIN_IS_REQUIRED,
    /**
     * The withdrawal limit has been exceeded.
     */
    @SerializedName("61")
    WITHDRAW_LIMIT_EXCEEDED,
    /**
     * A security violation occurred.
     */
    @SerializedName("63")
    SECURITY_VIOLATION,
    /**
     * The amount is higher than the original transaction.
     */
    @SerializedName("64")
    AMOUNT_HIGHER_THAN_ORIGINAL_TRANSACTION,
    /**
     * Retry in contact mode.
     */
    @SerializedName(value = "65", alternate = {"11010"})
    RETRY_IN_CONTACT_MODE,
    /**
     * A delayed response occurred.
     */
    @SerializedName("68")
    DELAYED_RESPONSE,
    /**
     * The issuer does not support this service.
     */
    @SerializedName("77")
    ISSUER_DO_NOT_SUPPORT_THIS_SERVICE,
    /**
     * The customer is not eligible for POS.
     */
    @SerializedName("78")
    CUSTOMER_NOT_ELIGIBLE_FOR_POS,
    /**
     * A network error occurred.
     */
    @SerializedName("80")
    NETWORK_ERROR,
    /**
     * A PIN cryptographic error occurred.
     */
    @SerializedName("81")
    PIN_CRYPTOGRAPHIC_ERROR,
    /**
     * The transaction timed out.
     */
    @SerializedName("82")
    TRANSACTION_TIMEOUT,
    /**
     * A communication failure occurred.
     */
    @SerializedName("83")
    COMMUNICATION_FAILURE,
    /**
     * Account number, address, or CVV2 verification failed.
     */
    @SerializedName("85")
    ACCOUNT_NUMBER_ADDRESS_CVV2_VERIFICATION_FAILURE,
    /**
     * PIN validation is not possible.
     */
    @SerializedName("86")
    PIN_VALIDATION_NOT_POSSIBLE,
    /**
     * The cashback amount was declined.
     */
    @SerializedName("87")
    CASHBACK_AMOUNT_DECLINED,
    /**
     * A cryptographic failure occurred.
     */
    @SerializedName("88")
    CRYPTOGRAPHIC_FAILURE,
    /**
     * An authentication failure occurred.
     */
    @SerializedName("89")
    AUTHENTICATION_FAILURE,
    /**
     * The issuer is temporarily not reachable.
     */
    @SerializedName("91")
    ISSUER_TEMPORARILY_NOT_REACHABLE,
    /**
     * The card type is invalid.
     */
    @SerializedName("92")
    INVALID_CARD_TYPE,
    /**
     * The transaction is a duplicate.
     */
    @SerializedName("94")
    DUPLICATED_TRANSACTION,
    /**
     * A reconcile error occurred.
     */
    @SerializedName("95")
    RECONCILE_ERROR,
    /**
     * The transaction was cancelled.
     */
    @SerializedName("3000")
    CANCELLED,
    /**
     * The transaction is incomplete.
     */
    @SerializedName("11000")
    INCOMPLETE_TRANSACTION,
    /**
     * A processing error occurred.
     */
    @SerializedName("11008")
    PROCESSING_ERROR,
    /**
     * The PIN pad is not initialized.
     */
    @SerializedName("11009")
    PIN_PAD_NOT_INITIALIZED,
    /**
     * The transaction has expired and is incomplete.
     */
    @SerializedName("11011")
    EXPIRED_INCOMPLETE,
    /**
     * The technical reversal failed.
     */
    @SerializedName("11012")
    TECHNICAL_REVERSAL_FAILED,
    /**
     * The processor was not found.
     */
    @SerializedName("11013")
    PROCESSOR_NOT_FOUND
}
