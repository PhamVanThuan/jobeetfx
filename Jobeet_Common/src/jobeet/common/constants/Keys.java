package jobeet.common.constants;

/**
 * Constants for key names in .properties files, array keys, index keys etc.
 */
public final class Keys {

    /**
     * Key names in application config file for global configurations.
     */
    public final class AppConfig {
        
        /**
         * Value: "app.preloaderCountDown"
         */
        public final static String APP_PRELOADER_COUNTDOWN = "app.preloaderCountDown";
        
        /**
         * Value: "app.productName"
         */
        public final static String APP_PRODUCT_NAME = "app.productName";

        /**
         * Value: "app.version"
         */
        public final static String APP_VERSION = "app.version";

        /**
         * Value: "areaNetwork.list"
         */
        public final static String AREA_NETWORK_NAMES = "areaNetwork.list";

        /**
         * Value: "app.dir.base"
         */
        public final static String BASE_DIR = "app.dir.base";

        /**
         * Value: "app.charset"
         */
        public final static String APP_CHARSET = "app.charset";
        
        /**
         * Value: "app.languageResourceName"
         */
        public final static String LANGUAGE_RESOURCE_NAME = "app.languageResourceName";

        /**
         * Value: "app.languageResourcePath"
         */
        public final static String LANGUAGE_RESOURCE_PATH = "app.languageResourcePath";

        /**
         * Value: "app.locale"
         */
        public final static String LOCALE = "app.locale";

        /**
         * Value: "app.dir.lib"
         */
        public final static String LIB_DIR = "app.dir.lib";

        /**
         * Value: "app.dir.log"
         */
        public final static String LOG_DIR = "app.dir.log";

        /**
         * Value: "app.dir.plugins"
         */
        public final static String PLUGINS_DIR = "app.dir.plugins";
        
        /**
         * Value: "registration.department"
         */
        public final static String REGISTRATION_DEPARTMENT = "registration.department";

        /**
         * Value: "registration.departmentDesc"
         */
        public final static String REGISTRATION_DEPARTMENT_DESC = "registration.departmentDesc";

        /**
         * Value: "registration.departmentCodeSys"
         */
        public final static String REGISTRATION_DEPARTMENT_CODESYS = "registration.departmentCodeSys";

        /**
         * Value: "registration.licenseDesc"
         */
        public final static String REGISTRATION_LICENSE_DESC = "registration.licenseDesc";

        /**
         * Value: "registration.license"
         */
        public final static String REGISTRATION_LICENSE = "registration.license";

        /**
         * Value: "registration.licenseCodeSys"
         */
        public final static String REGISTRATION_LICENSE_CODESYS = "registration.licenseCodeSys";

        /**
         * Value: "registration.infoFile"
         */
        public final static String REGISTRATION_INFO_FILE = "registration.infoFile";

        /**
         * Value: "registration.length.userId"
         */
        public final static String REGISTRATION_LENGTH_USERID = "registration.length.userId";

        /**
         * Value: "registration.length.password"
         */
        public final static String REGISTRATION_LENGTH_PASSWORD = "registration.length.password";

        /**
         * Value: "registration.pattern.idPass"
         */
        public final static String REGISTRATION_PATTERN_IDPASS = "registration.pattern.idPass";
        
        /**
         * Value: "registration.pattern.digit"
         */
        public final static String REGISTRATION_PATTERN_DIGIT = "registration.pattern.digit";
        
        /**
         * Value: "registration.pattern.email"
         */
        public final static String REGISTRATION_PATTERN_EMAIL = "registration.pattern.email";
        
        /**
         * Value: "app.dir.setting"
         */
        public final static String SETTING_DIR = "app.dir.setting";

        /**
         * Value: "app.dir.security"
         */
        public final static String SECURITY_DIR = "app.dir.security";

        /**
         * Value: "app.dir.schema"
         */
        public final static String SCHEMA_DIR = "app.dir.schema";

        /**
         * Value: "app.version"
         */
        public final static String VERSION = "app.version";
    }

    public final class Language {
         /**
         * Value: "Account_creation"
         */
        public final static String ACCOUNT_CREATION = "Account_creation";
        
        /**
         * Value: "An_error_occured"
         */
        public final static String AN_ERROR_OCCURED = "An_error_occured";

        /**
         * Value: "Environment_settings"
         */
        public final static String ENVIRONMENT_SETTINGS = "Environment_settings";

        public final static String SCHEMA = "Schema_box_title";
        
        public final static String ABOUT = "ProductString";
        
        public final static String CHANGEPASSWORD = "Change_password";
        
        public final static String ADDING_USER = "Adding_user";
        
        /**
         * Value: "Login"
         */
        public final static String LOGIN = "Login";

        /**
         * Value: "Login_failed"
         */
        public final static String LOGGING_IN_FAILED = "Logging_in_failed";
        
        /**
         * Value: "Saving_stamp"
         */
        public final static String SAVING_STAMP = "Saving_stamp";
        
        /**
         * Value: "Stamp_box"
         */
        public final static String STAMP_BOX = "Stamp_box";        
        
        /**
         * Value: "ORCA_set_search"
         */
        public final static String ORCA_SET_SEARCH = "ORCA_set_search";
        
        /**
         * Value: "Personal_use"
         */
        public final static String PERSONAL_USE = "Personal_use";
        
        /**
         * Value: "This_is_a_personal_stamp_set"
         */
        public final static String THIS_IS_A_PERSONAL_STAMP_SET = "This_is_a_personal_stamp_set";
        
        /**
         * Value: "Username_or_password_is_incorrect"
         */
        public final static String USERNAME_OR_PASSWORD_IS_INCORRECT = "Username_or_password_is_incorrect";

    }

    /**
     * Key names of settings.
     */
    public final class Settings {
        public static final String AREA_NETWORK_NAME = "areaNetName";
        public static final String AREA_NETWORK_FACILITY_ID = "areaNetFacilityId";
        public static final String AREA_NETWORK_CREATOR_ID = "areaNetCreatorId";public static final String CLAIM_HOST_NAME = "claimHostName";
        public static final String BIND_ADDRESS = "bindAdd";
        public static final String CLAIM01 = "CLAIM01";
        public static final String CLAIM_VERSION = "claimVersion";
        public static final String CLAIM_ENCODING = "claimEncoding";
        public static final String CLAIM_ADDRESS = "claimAddress";
        public static final String CLAIM_PORT = "claimPort";
        public static final String DATABASE_ADDRESS = "settings.dbAddress";
        public static final String DATABASE_PORT = "settings.dbPort";
        public static final String DATABASE_NAME = "settings.dbName";
        public static final String DATABASE_USERNAME = "settings.dbUsername";
        public static final String DATABASE_PASSWORD = "settings.dbPassword";
        public static final String DATABASE_DRIVER = "settings.dbDriver";
        public static final String FACILITY_ID = "facId";
        public static final String JMARI_CODE = "jmariCode";
        public static final String JOIN_AREA_NETWORK = "joinAreaNet";
        public static final String SEND_MML = "mmlSend";
        public static final String MML_VERSION = "mmlVer";
        public static final String MODIFIER = "modifier";
        public static final String MML_ENCODING = "mmlEnc";
        public static final String ORCA_VERSION = "orcaVer";
        public static final String SEND_MML_ADDRESS = "mmlAdd";
        public static final String SEND_MML_DIRECTORY = "mmlDir";
        public static final String SEND_MML_PROTOCOL = "mmlPro";
        public static final String SEND_CLAIM = "sendClaim";
        public static final String SEND_CLAIM_SAVE = "sendClaimSave";
        public static final String SEND_CLAIM_TMP = "sendClaimTmp";
        public static final String SEND_CLAIM_MODIFY = "sendClaimModify";
        public static final String SEND_DIAGNOSIS = "sendDiagnosis";
        public static final String STAMP_TEXT = "stpTxt";
        public static final String STAMP_PATH = "stpPath";
        public static final String STAMP_GENERAL_ORDER = "stpGenOrder";
        public static final String STAMP_OTHER_ORDER = "stpOthOrder";
        public static final String STAMP_TREATMENT = "stpTreat";
        public static final String STAMP_SURGERY_ORDER = "stpSur";
        public static final String STAMP_RADIOLOGY_ORDER = "stpRad";
        public static final String STAMP_LABO_TEST = "stpLabo";
        public static final String STAMP_PHYSIOLOGY_ORDER = "stpPhy";
        public static final String STAMP_BACTERIA_ORDER = "stpBac";
        public static final String STAMP_INJECTION_ORDER = "stpInj";
        public static final String STAMP_MED_ORDER = "stpMed";
        public static final String STAMP_BASE_CHARGE_ORDER = "stpBaseCharge";
        public static final String STAMP_INSTRACTION_CHARGE_ORDER = "stpInsCharge";
        public static final String STAMP_ORCA = "stpOrca";
        public static final String USER_TYPE = "userType";
        public static final String USER_ID = "userId";
        public static final String USE_AS_PVT_SERVER = "useAsPVTServer";
        
        public final class Confirmation {
            public static final String CREATE_NEW_CHART = "settingMedicalConfirmationCreateNewChart";
            public static final String CREATE_MODE = "settingMedicalConfirmationCreateMode";
            public static final String LAYOUT_METHOD = "settingMedicalConfirmationLayoutMethod";
            public static final String CREATE_RECORD_MODE = "settingMedicalConfirmationCreateRecordMode";
        
            public static final String SAVING = "settingMedicalConfirmationSaving";
            public static final String NUMOFCOPY = "settingMedicalConfirmationNumOfCopy";
            public static final String OPERATION = "settingMedicalConfirmationOpperation";
        }
        
        public final class MedicalTreatment {
            public static final String USE_TITLE_FOR_CHART = "useTitleForChart";
            public static final String TITLE_FOR_CHART = "titleForChart";
            public static final String OPPERATION_WITH_PRIVISIONAL_STORAGE = "opperationWithPrivisionalStorage";
            public static final String OPPERATION_WITH_STORAGE = "opperationWithStorage";
            public static final String OPPERATION_WITH_CORRECTING = "opperationWithCorrecting";
            public static final String OPPERATION_WITH_SICK_NAME = "opperationWithSickName";
        }
        
        public final class MedicalStamp {
            public static final String MEDICAL_DND_ON_STAMP = "medicalDnDOnStamp";
            public static final String SPACING_OF_STAMP = "spacingOfStamp";
            public static final String FOLDING_LABORATORY_TEST = "foldingLaboratoryTest";
            public static final String TABLE_CASE = "tabletCase";
            public static final String LIQUID_MEDICINE_CASE = "liquidMedicineCase";
            public static final String POWERED_MEDICINE_CASE = "powderedMedicineCase";
            public static final String PRESCRIBED_DAYS = "prescribedDays";
        }
        public final class MedicalDocument {
            public static final String DOCUMENT_HISTORY_SORTING = "documentHistorySorting";
            public static final String NUMBER_OF_DOCUMENT = "numberOfDocument";
            public static final String SCROLL_DIRECTION = "scrollDirection";
            public static final String EXTRACTION_PERIOD = "extractionPeriod";
            public static final String DISPLAY_ORDER = "displayOrder";
            public static final String SICK_NAME_EXTRACTION_PERIOD = "sickNameExtractionPeriod";
            public static final String AUTO_ENTER_END_DATE = "autoEnterEndDate";
            public static final String INPUT_DAY = "inputDay";
        }
        public final class MedicalInspector {
            public static final String MEDICAL_INSPECTOR_SCREEN_LEFT_TOP = "medicalInspectorScreenLeftTop";
            public static final String MEDICAL_INSPECTOR_SCREEN_SECOND = "medicalInspectorScreenSecond";
            public static final String MEDICAL_INSPECTOR_SCREEN_THIRD = "medicalInspectorScreenThird";
            public static final String MEDICAL_INSPECTOR_SCREEN_BOTTOM = "medicalInspectorScreenBottom";
            public static final String MEDICAL_INSPECTOR_SCREEN_LOCATOR = "medicalInspectorScreenLocator";
            public static final String MEDICAL_INSPECTOR_SCREEN_DESTINATION = "medicalInspectorScreenDestination";
        }
        public final class AppointmentSearce {
            public static final String AGE_OF_DISLAY = "ageDisplay";
            public static final String AUTO_IME = "autoIme";
        }
    }

}
