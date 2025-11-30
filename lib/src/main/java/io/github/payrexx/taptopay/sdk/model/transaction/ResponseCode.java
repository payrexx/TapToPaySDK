package io.github.payrexx.taptopay.sdk.model.transaction;

import com.google.gson.annotations.SerializedName;

public enum ResponseCode {
    @SerializedName("-1")
    UNKNOWN,
    @SerializedName("0")
    SUCCESS,
    @SerializedName(value="1", alternate = {"2", "8"})
    REFER_TO_CARD_ISSUER,
    @SerializedName("3")
    INVALID_MERCHANT_NUMBER,
    @SerializedName(value = "4", alternate = {"7", "34", "37", "66", "67"})
    RETAIN_CARD,
    @SerializedName("5")
    DO_NOT_HONOR,
    @SerializedName(value = "6", alternate = {"30", "79", "96", "97", "98", "99"})
    SYSTEM_ERROR,
    @SerializedName("9")
    PLEASE_WAIT,
    @SerializedName("10")
    PARTIAL_APPROVAL,
    @SerializedName("12")
    INVALID_TRANSACTION,
    @SerializedName("13")
    INVALID_AMOUNT,
    @SerializedName("14")
    INVALID_CARD,
    @SerializedName("15")
    UNABLE_TO_ROUTE_TO_ISSUER,
    @SerializedName("21")
    NO_ACTION_TAKEN,
    @SerializedName("25")
    UNABLE_TO_LOCATE_RECORD_ON_FILE,
    @SerializedName("28")
    THE_FILE_IS_NOT_ACCESSIBLE,
    @SerializedName("31")
    FORMAT_ERROR,
    @SerializedName(value = "33", alternate = {"54"})
    CARD_EXPIRED,
    @SerializedName(value = "36", alternate = {"62"})
    RESTRICTED_CARD,
    @SerializedName(value = "38", alternate = {"75"})
    PIN_ENTRY_TRIES_EXCEEDED,
    @SerializedName("40")
    FUNCTION_NOT_SUPPORTED,
    @SerializedName("41")
    CARD_REPORTED_AS_LOST,
    @SerializedName("43")
    CARD_REPORTED_AS_STOLEN,
    @SerializedName("51")
    INSUFFICIENT_FUNDS,
    @SerializedName("52")
    NO_CHECKING_ACCOUNT,
    @SerializedName("53")
    NO_SAVINGS_ACCOUNT,
    @SerializedName(value = "55", alternate = {"76"})
    INCORRECT_PIN,
    @SerializedName("56")
    UNKNOWN_CARD,
    @SerializedName("57")
    ORIGINAL_TRANSACTION_NOT_FOUND,
    @SerializedName("58")
    UNKNOWN_TERMINAL,
    @SerializedName("60")
    PIN_IS_REQUIRED,
    @SerializedName("61")
    WITHDRAW_LIMIT_EXCEEDED,
    @SerializedName("63")
    SECURITY_VIOLATION,
    @SerializedName("64")
    AMOUNT_HIGHER_THAN_ORIGINAL_TRANSACTION,
    @SerializedName(value = "65", alternate = {"11010"})
    RETRY_IN_CONTACT_MODE,
    @SerializedName("68")
    DELAYED_RESPONSE,
    @SerializedName("77")
    ISSUER_DO_NOT_SUPPORT_THIS_SERVICE,
    @SerializedName("78")
    CUSTOMER_NOT_ELIGIBLE_FOR_POS,
    @SerializedName("80")
    NETWORK_ERROR,
    @SerializedName("81")
    PIN_CRYPTOGRAPHIC_ERROR,
    @SerializedName("82")
    TRANSACTION_TIMEOUT,
    @SerializedName("83")
    COMMUNICATION_FAILURE,
    @SerializedName("85")
    ACCOUNT_NUMBER_ADDRESS_CVV2_VERIFICATION_FAILURE,
    @SerializedName("86")
    PIN_VALIDATION_NOT_POSSIBLE,
    @SerializedName("87")
    CASHBACK_AMOUNT_DECLINED,
    @SerializedName("88")
    CRYPTOGRAPHIC_FAILURE,
    @SerializedName("89")
    AUTHENTICATION_FAILURE,
    @SerializedName("91")
    ISSUER_TEMPORARILY_NOT_REACHABLE,
    @SerializedName("92")
    INVALID_CARD_TYPE,
    @SerializedName("94")
    DUPLICATED_TRANSACTION,
    @SerializedName("95")
    RECONCILE_ERROR,
    @SerializedName("3000")
    CANCELLED,
    @SerializedName("11000")
    INCOMPLETE_TRANSACTION,
    @SerializedName("11008")
    PROCESSING_ERROR,
    @SerializedName("11009")
    PIN_PAD_NOT_INITIALIZED,
    @SerializedName("11011")
    EXPIRED_INCOMPLETE,
    @SerializedName("11012")
    TECHNICAL_REVERSAL_FAILED,
    @SerializedName("11013")
    PROCESSOR_NOT_FOUND
}
