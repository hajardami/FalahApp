package com.backFalahApp.BackFalahApp.enumerations;

public enum ExpertDocuments {
    EXPERT_CERTIFICATE("expertCertificate"),
    /**
     * could be either id, passport, or other documents
     */
    IDENTITY_DOCUMENT("identityDocument"),
    /**
     * portrait photo
     */
    IMAGE("image"),
    UNKNOWN_DOCUMENT("unknownDocument");

    private final String valueField;

    ExpertDocuments(String valueField) {
        this.valueField = valueField;
    }

    public final String value() { return this.valueField; }

    public static ExpertDocuments fromValue (String valueField) {
        for(ExpertDocuments requestName : ExpertDocuments.values())
            if(requestName.valueField.equals(valueField)) return requestName;
        return UNKNOWN_DOCUMENT;
    }
}
