package jobeet.common.constants;

/**
 * Constant for general values.
 */
public final class Values {

    public final class Paths {
    
        /**
         * Path to application config file.<br/>
         * Value: "./config/app.properties"
         */
        public static final String APP_CONFIG = "./config/app.properties";
        
        /**
         * Path to logger config file.<br/>
         * Value: "/open/dolphin/resources/config/log4j.properties"
         */
        public static final String LOG_CONFIG = "./config/log4j.properties";
        
        /**
         * Value: "stamptree-seed.xml"
         */
        public static final String STAMP_TREE_SEED = "stamptree-seed.xml";
    }

    public enum UserType {
        ASP_MEMBER, ASP_TESTER, ASP_DEV, FACILITY_USER, UNKNOWN, EXPIRED
    }
}
