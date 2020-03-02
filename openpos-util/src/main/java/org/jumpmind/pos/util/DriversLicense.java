package org.jumpmind.pos.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriversLicense {

    private Map<String, String> elements;

    private String firstLine;

    private String fileType;

    private String issuerIDNumber;

    private String AAMVABarCodeVersion;

    private String jurisdictionBarCodeVersion;

    private String numberOfSubFiles;

    private String jurisdictionVehicleClass;

    private String jurisdictionRestrictionCode;

    private String jurisdictionEndorsementCode;

    private Date expirationDate;

    private String lastName;

    private String firstName;

    private String[] middleNames;

    private Date issueDate;

    private Character sex;

    private Date dateOfBirth;

    private String eyeColor;

    private String height;

    private String addressStreet1;

    private String city;

    private String stateCode;

    private String postalCode;

    private String idNumber;

    private String documentDiscriminator;

    private String countryID;

    private Character lastNameTruncationStatus;

    private Character firstNameTruncationStatus;

    private Character middleNameTruncationStatus;

    private String addressStreet2;

    private String hairColor;

    private String placeOfBirth;

    private String auditInformation;

    private String inventoryControlNumber;

    private String lastNameAlias;

    private String firstNameAlias;

    private String nameSuffixAlias;

    private String nameSuffix;

    private Integer weightRange;

    private String raceOrEthnicity;

    private String standardVehicleClassification;

    private String standardEndorsementCode;

    private String standardRestrictionCode;

    private String jurisdictionVehicleClassDescription;

    private String jurisdictionEndorsementCodeDescription;

    private String jurisdictionRestrictionCodeDescription;

    private Character complianceType;

    private Date cardRevisionDate;

    private Date hazmatEndorsementExpirationDate;

    private boolean limitedDurationIndicator;

    private Integer weightInPounds;

    private Integer weightInKilograms;

    private Date under18Until;

    private Date under19Until;

    private Date under21Until;

    private boolean organDonorIndicator;

    private boolean veteranIndicator;

    public DriversLicense() {
        elements = new HashMap<>();
    }

    public DriversLicense(String data) {
        elements = new HashMap<>();
        parse(data);
        setAttributes();
    }

//    public void parse(InputStream stream) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//        String line;
//        while((line = reader.readLine()) != null) {
//            if (line.length() > 2) {
//                if (line.startsWith("ANSI")) {
//                    firstLine = line;
//                    String[] splitFirstLine = line.split("DL");
//                    elements.put(splitFirstLine[splitFirstLine.length-1].substring(0, 3), splitFirstLine[splitFirstLine.length-1].substring(3));
//                } else {
//                    elements.put(line.substring(0, 3), line.substring(3));
//                }
//            }
//        }
//        setAttributes();
//    }

    public void parse(String data)  {
        elements.clear();
        String[] lines = data.split("\r\n|\n|\r");
        for (String line : lines) {
            if (line.length() > 2) {
                if (line.startsWith("\u001E")) {
                    firstLine = line.substring(1);
                    String[] splitFirstLine = line.split("DL");
                    elements.put(splitFirstLine[splitFirstLine.length-1].substring(0, 3), splitFirstLine[splitFirstLine.length-1].substring(3));
                } else {
                    elements.put(line.substring(0, 3), line.substring(3));
                }
            }
        }
        setAttributes();
    }

    private void setAttributes() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("MMddyyyy");
            fileType = firstLine.substring(0, 5);
            issuerIDNumber = firstLine.substring(5, 11);
            AAMVABarCodeVersion = firstLine.substring(11, 13);
            jurisdictionBarCodeVersion = firstLine.substring(13, 15);
            numberOfSubFiles = firstLine.substring(15, 17);
            jurisdictionVehicleClass = elements.get("DCA");
            jurisdictionRestrictionCode = elements.get("DCB");
            jurisdictionEndorsementCode = elements.get("DCD");
            expirationDate = format.parse(elements.get("DBA"));
            lastName = elements.get("DCS");
            firstName = elements.get("DAC");
            middleNames = elements.get("DAD").split(",");
            issueDate = format.parse(elements.get("DBD"));
            sex = elements.get("DBC").equals("9") ? 'U' : (elements.get("DBC").equals("1")) ? 'M' : 'F';
            dateOfBirth = format.parse(elements.get("DBB"));
            eyeColor = elements.get("DAY");
            height = elements.get("DAU");
            addressStreet1 = elements.get("DAG");
            city = elements.get("DAI");
            stateCode = elements.get("DAJ");
            postalCode = elements.get("DAK");
            idNumber = elements.get("DAQ");
            documentDiscriminator = elements.get("DCF");
            countryID = elements.get("DCG");
            lastNameTruncationStatus = elements.get("DDE").charAt(0);
            firstNameTruncationStatus = elements.get("DDF").charAt(0);
            middleNameTruncationStatus = elements.get("DDG").charAt(0);

            //optional
            addressStreet2 = elements.get("DAH");
            hairColor = elements.get("DAZ");
            placeOfBirth = elements.get("DCI");
            auditInformation = elements.get("DCJ");
            inventoryControlNumber = elements.get("DCK");
            lastNameAlias = elements.get("DBN");
            firstNameAlias = elements.get("DBG");
            nameSuffixAlias = elements.get("DBS");
            nameSuffix = elements.get("DCU");
            weightRange = elements.get("DCE") != null ? Integer.parseInt(elements.get("DCE")) : null;
            raceOrEthnicity = elements.get("DCL");
            standardVehicleClassification = elements.get("DCM");
            standardEndorsementCode = elements.get("DCN");
            standardRestrictionCode = elements.get("DCO");
            jurisdictionVehicleClassDescription = elements.get("DCP");
            jurisdictionEndorsementCodeDescription = elements.get("DCQ");
            jurisdictionRestrictionCodeDescription = elements.get("DCR");
            complianceType = elements.get("DDA") != null ? elements.get("DDA").charAt(0) : null;
            cardRevisionDate = (elements.get("DDB") != null && elements.get("DDB").length() > 1) ? format.parse(elements.get("DDB")) : null;
            hazmatEndorsementExpirationDate = (elements.get("DDC") != null && elements.get("DDC").length() > 1) ? format.parse(elements.get("DDC")) : null;
            limitedDurationIndicator = elements.get("DDD") != null && elements.get("DDD").contains("1");
            weightInPounds = elements.get("DAW") != null ? Integer.parseInt(elements.get("DAW")) : null;
            weightInKilograms = elements.get("DAX") != null ? Integer.parseInt(elements.get("DAX")) : null;
            under18Until = (elements.get("DDH") != null && elements.get("DDH").length() > 1) ? format.parse(elements.get("DDH")) : null;
            under19Until = (elements.get("DDI") != null && elements.get("DDI").length() > 1) ? format.parse(elements.get("DDI")) : null;
            under21Until = (elements.get("DDJ") != null && elements.get("DDJ").length() > 1) ? format.parse(elements.get("DDJ")) : null;
            organDonorIndicator = elements.get("DDK") != null && elements.get("DDK").contains("1");
            veteranIndicator = elements.get("DDL") != null && elements.get("DDL").contains("1");
        } catch (Exception e) {
            if (e instanceof NullPointerException)
                Logger.getLogger(DriversLicense.class.getName()).log(Level.WARNING, "Failed to parse Driver's License, most likely due to a missing required attribute or incorrect format.");
            else
                Logger.getLogger(DriversLicense.class.getName()).log(Level.WARNING, "Failed to parse Driver's License, most likely due to an incorrectly formatted value.");
        }

    }

    public String getFileType() { return fileType; }

    public String getIssuerIDNumber() { return issuerIDNumber; }

    public String getAAMVABarCodeVersion() { return AAMVABarCodeVersion; }

    public String getJurisdictionBarCodeVersion() { return jurisdictionBarCodeVersion; }

    public String getNumberOfSubFiles() { return numberOfSubFiles; }

    public String getJurisdictionVehicleClass() { return jurisdictionVehicleClass; }

    public String getJurisdictionRestrictionCode() { return jurisdictionRestrictionCode; }

    public String getHurisdictionEndorsementCode() { return jurisdictionEndorsementCode; }

    public Date getExpirationDate() { return expirationDate; }

    public String getLastName() { return lastName; }

    public String getFirstName() { return firstName; }

    public String[] getMiddleNames() { return middleNames; }

    public Date getIssueDate() { return issueDate; }

    public Character getSex() { return sex; }

    public Date getDateOfBirth() { return dateOfBirth; }

    public String getEyeColor() { return eyeColor; }

    public String getHeight() { return height; }

    public String getAddressStreet1() { return addressStreet1; }

    public String getCity() { return city; }

    public String getStateCode() { return stateCode; }

    public String getPostalCode() { return postalCode; }

    public String getIDNumber() { return idNumber; }

    public String getDocumentDiscriminator() { return documentDiscriminator; }

    public String getCountryID() { return countryID; }

    public Character getLastNameTruncationStatus() { return lastNameTruncationStatus; }

    public Character getFirstNameTruncationStatus() { return firstNameTruncationStatus; }

    public Character getMiddleNameTruncationStatus() { return middleNameTruncationStatus; }

    public String getAddressStreet2() { return addressStreet2; }

    public String getHairColor() { return hairColor; }

    public String getPlaceOfBirth() { return placeOfBirth; }

    public String getAuditInformation() { return auditInformation; }

    public String getInventoryControlNumber() { return inventoryControlNumber; }

    public String getLastNameAlias() { return lastNameAlias; }

    public String getFirstNameAlias() { return firstNameAlias; }

    public String getNameSuffixAlias() { return nameSuffixAlias; }

    public String getNameSuffix() { return nameSuffix; }

    public Integer getWeightRange() { return weightRange; }

    public String getRaceOrEthnicity() { return raceOrEthnicity; }

    public String getStandardVehicleClassification() { return standardVehicleClassification; }

    public String getStandardEndorsementCode() { return standardEndorsementCode; }

    public String getStandardRestrictionCode() { return standardRestrictionCode; }

    public String getJurisdictionVehicleClassDescription() { return jurisdictionVehicleClassDescription; }

    public String getJurisdictionEndorsementCodeDescription() { return jurisdictionEndorsementCodeDescription; }

    public String getJurisdictionRestrictionCodeDescription() { return jurisdictionRestrictionCodeDescription; }

    public Character getComplianceType() { return complianceType; }

    public Date getCardRevisionDate() { return cardRevisionDate; }

    public Date getHazmatEndorsementExpirationDate() { return hazmatEndorsementExpirationDate; }

    public boolean getLimitedDurationIndicator() { return limitedDurationIndicator; }

    public Integer getWeightInPounds() { return weightInPounds; }

    public Integer getWeightInKilograms() { return weightInKilograms; }

    public Date getUnder18Until() { return under18Until; }

    public Date getUnder19Until() { return under19Until; }

    public Date getUnder21Until() { return under21Until; }

    public boolean getOrganDonorIndicator() { return organDonorIndicator; }

    public boolean getVeteranIndicator() { return veteranIndicator; }
}