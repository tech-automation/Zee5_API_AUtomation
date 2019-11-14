package co.Zee5.api.config;

import co.Zee5.api.helper.PropertyReader;

public interface Constants {

	/* **************** Property file paths **************** */
	String URL_PROPERTIES_PATH = "./src/main/java/co/sharechat/api/config/URL_Config.properties";
	String GOOGLE_SPREADSHEET_PROPERTIES_PATH = "./src/main/java/co/sharechat/api/config/GoogleSheetIDs_Config.properties";
	String COMMON_PROPERTIES_PATH = "./src/main/java/co/sharechat/api/config/CommonValues.properties";
	String FILE_PATHS_PROPERTIES_PATH = "./src/main/java/co/sharechat/api/config/FilePathsConfig.properties";

	/* **************** Environments **************** */
	String ENVIRONMENT = System.getProperty("env");

	/* **************** Headers **************** */
	String APPLICATION_JSON = "application/json";
	String SHARECHAT_AUTHORIZED_USERID = "X-SHARECHAT-AUTHORIZED-USERID";
	String SHARE_CHAT_SECRET = "X-SHARECHAR-SECRET";
	String SHAR_CHAT_USER_ID = "X-SHARECHAT-USERID";

	/* **************** Excel paths **************** */
	String USER_SERVICE_XL_PATH = "./Test Data/UserServiceTestData.xlsx";
	String XL_PATH = "./Test Data/TestData2.xlsx";
	String POST_SERVICE_XL_PATH = "./Test Data/PostServiceTestData.xlsx";
	String MOOD_SERVICE_XL_PATH = "./Test Data/MoodServiceData.xlsx";
	String NOTIFICATION_SERVICE_XL_PATH = "./Test Data/NotificationServiceTestData.xlsx";

	/* **************** Account Service Resources **************** */
	String ACCOUNT_SERVICE = "ACCOUNT_SERVICE";
	String STATUS_CODE = "Status code";
	String ACCOUNT_USER_ID_KEY = "userId";

	String GET_INFO_SCHEMA_FILE = PropertyReader.getProperty(FILE_PATHS_PROPERTIES_PATH, "GET_INFO");
	String USER_IDN = "USER_IDN";
	String FIRST_ACCOUNT_ID = "FIRST_ACCOUNT_ID";
	String SECOND_ACCOUNT_ID = "SECOND_ACCOUNT_ID";
	String STATUS_CODE_SUCCESS = "STATUS_CODE_SUCCESS";
	String STATUS_CODE_CLIENT_FAILURE = "STATUS_CODE_CLIENT_FAILURE";
	String ACCOUNT_JWT_ID = "ACCOUNT_JWT_ID";
	String ACCOUNT_POST_VERIFY_ID = "ACCOUNT_POST_VERIFY_ID";
	String ACCOUNT_ID_AUTH_MECHANISM = "ACCOUNT_ID_AUTH_MECHANISM";
	String ACCOUNT_PHONE_NUM_PREFIX = "ACCOUNT_PHONE_NUM_PREFIX";

	String SIGNUP = "/signUp";
	String SIGNUP_SHEET = "SignUpData";

	String GET_LANGUAGE_LIST = "/getLangList";

	String ACCOUNT_SEND_SMS = "/sendSms";
	String ACCOUNT_SEND_SMS_SHEET = "SendSMSData";

	String ACCOUNT_USER = "/get";

	String ACCOUNT_JWT = "getJwtToken/";

	String ACCOUNT_BATCH_SHEET = "AccountUserBatch";
	String ACCOUNT_BATCH = "/batchGet";
	String GET_BATCH_SCHEMA_FILE = PropertyReader.getProperty(FILE_PATHS_PROPERTIES_PATH, "GET_BATCH");
	String ACCOUNT_USER_IDS = "userIds";

	String VERIFY_OTP = "/verifyOtp";
	String ACCOUNT_VERIFY_OTP_SHEET = "VerifyOtpData";

	/* **************** Post Rendering Service Resources **************** */
	String POST_RENDERING_SERVICE = "POST_RENDERING_SERVICE";
	String POST_CARDS_SHEET = "PostCards";
	String POST_CARDS = "/postCards";
	String POST_SUMMARY = "/PostSummary";
	String POST_USER_ID = PropertyReader.getProperty(COMMON_PROPERTIES_PATH, "POST_SERVICE_USER_ID");
	String LINK_TYPE_POST_IDS = PropertyReader.getProperty(COMMON_PROPERTIES_PATH, "LINK_TYPE_POST_ID");

	/* **************** Compose Service Resources **************** */
	String COMPOSE_SERVICE = "COMPOSE_SERVICE";

	String UPLOAD_UGC_SHEET = "UploadUGC";
	String UPLOAD_UGC_400_SHEET = "UploadUGC400";
	String UPLOAD_UGC = "/uploadugc";
	String PI_MAX_VALUE = "PI_MAX_VALUE";
	String PI_MIN_VALUE = "PI_MIN_VALUE";
	String UPLOAD_UGC_SCHEMA_FILE = PropertyReader.getProperty(FILE_PATHS_PROPERTIES_PATH, "UPLOAD_UGC");

	String GET_STICKERS = "/getStickers";

	String GET_STICKERS_SHEET = "Stickers";

	String GET_AUDIO_CATEGORIES = "/getAudioCategories";
	String COMPOSE_SERVICE_USERID = "23444555";

	String GET_AUDIO_LIST = "/getAudioList";
	String AUDIO_LIST_CLIENT_ERROR = "AUDIO_LIST_CLIENT_ERROR";
	String AUDIO_LIST_SCHEMA_FILE = PropertyReader.getProperty(FILE_PATHS_PROPERTIES_PATH, "AUDIO_LIST");
	String AUDIO_LIST_SHEET = "AudioList";
	String AUDIO_LIST_LANGUAGE = "AUDIO_LIST_LANGUAGE";
	String AUDIO_LIST_GENDER_FIELD = "AUDIO_LIST_GENDER_FIELD";
	String AUDIO_LIST_LOCATION = "AUDIO_LIST_LOCATION";
	String PAGE_VALUE = "PAGE_VALUE";
	String AUDIO_LIST_CATEGORY_ID = "AUDIO_LIST_CATEGORY_ID";

	String UPDATE_AUDIO = "/updateAudio";

	String UPDATE_AUDIO_CATEGORY = "/updateAudioCategory";
	String COMPOSE_UPDATE_AUDIO_LANGUAGES = "COMPOSE_UPDATE_AUDIO_LANGUAGES";

	String COMPOSE_CATEGORIES = "COMPOSE_CATEGORIES";
	String UPDATE_AUDIO_SHEET = "UpdateAudio";
	String UPDATE_AUDIO_CATEGORY_SHEET = "UpdateAudioCategory";

	String FAVOURITE_AUDIO = "/makeFavouriteAudio";
	String MAKE_FAVOURITE_AUDIO_USER_ID = "MAKE_FAVOURITE_AUDIO_USER_ID";
	String FAVOURITE_AUDIO_SHEET = "FavouriteAudio";

	/* **************** Post Service Resources **************** */
	String POST_SERVICE = "POST_SERVICE";

	/* **************** ShareChat Tool Resources **************** */
	String CREATE_TOOLS = "CREATE_TOOLS";
	String CREATE_TAG_ENDPOINT = "/tool9";
	String CREATE_BUCKET_ENDPOINT = "/tool8";

	/* **************** User Service Resources **************** */
	String USER_SERVICE = "USER_SERVICE";
	String USER_SERVICE_USER_ID = PropertyReader.getProperty(COMMON_PROPERTIES_PATH, "USER_SERVICE_USER_ID");
	String USER_SERVICE_INVALID_USER_ID = PropertyReader.getProperty(COMMON_PROPERTIES_PATH,
			"USER_SERVICE_INVALID_USER_ID");

	String GET_BATCH_USER_PERMISSION_SHEET = "BatchGetUserPermissions";
	String GET_BATCH_USER_PERMISSION_NEGATIVE_SHEET = "BatchGetUserPermissionsNegative";
	String GET_BATCH_USER_PERMISSION = "/batchGet/permissions";

	String INSERT_NEW_USER_SHEET = "InsertNewUser";
	String INSERT_NEW_USER_NEGATIVE_SHEET = "InsertNewUserNegative";
	String INSERT_NEW_USER_INVALID_SHEET = "InsertNewUserInvalid";
	String INSERT_NEW_USER = "/users";
	String EXISTING_USER_RESPONSE_MESSAGE = PropertyReader.getProperty(COMMON_PROPERTIES_PATH,
			"EXISTING_USER_RESPONSE_MESSAGE");

	String DEACTIVATE_USER_NEGATIVE_SHEET = "DeactivateUserNegative";
	String DEACTIVATE_USER = "/users/{userId}/deactivate";

	String UPDATE_USER_META_SHEET = "UpdateUserMeta";
	String UPDATE_USER_META_NEGATIVE_SHEET = "UpdateUserMetaNegative";
	String UPDATE_USER_META_INVALID_SHEET = "UpdateUserMetaInvalid";
	String UPDATE_USER_META = "/users/{userId}";

	String UPDATE_USER_PERMISSION = "/permission/{userId}";
	String UPDATE_USER_PERMISSION_SHEET = "UpdateUserPermission";
	String UPDATE_USER_PERMISSION_NEGATIVE_SHEET = "NegativeUpdateUserPermission";
	String VALID_PERMISSION = PropertyReader.getProperty(COMMON_PROPERTIES_PATH, "VALID_PERMISSION");
	String INVALID_PERMISSION = PropertyReader.getProperty(COMMON_PROPERTIES_PATH, "INVALID_PERMISSION");
	String VALID_PERMISSION_VALUE = PropertyReader.getProperty(COMMON_PROPERTIES_PATH, "VALID_PERMISSION_VALUE");
	String INVALID_PERMISSION_VALUE = PropertyReader.getProperty(COMMON_PROPERTIES_PATH, "INVALID_PERMISSION_VALUE");
	String EXTRA_MESSAGE = PropertyReader.getProperty(COMMON_PROPERTIES_PATH, "EXTRA_MESSAGE");
	String EXPECTED_MESSAGE = PropertyReader.getProperty(COMMON_PROPERTIES_PATH, "EXPECTED_MESSAGE");
	String MESSAGE_DONE = "done";

	String INCREMENT_USER_META_SHEET = "IncrementUserMeta";
	String INCREMENT_USER_META_NEGATIVE_SHEET = "IncrementUserMetaNegative";
	String INCREMENT_USER_META = "/permission/{userId}/incr";

	String GET_NEW_USERID = "/getNewUserId";
	String GET_NEW_USER_HANDLE = "/getNewHandle";
	String GET_MULTIPLE_USER_META = "/users";
	String GET_USER_PERMISSIONS = "/permission/";
	String META_USER = "/users";
	int USER_ID = 216;
	String USER_SETTINGS = "/userSettings";
	String USER_BATCH_SETTINGS = "/batchGet";
	String GET_USER_CLIENT = "/userClient";
	String BATCH_GET_USER_CLIENT = "/batchGet/userClient";

	/* **************** User Rendering Service Resources **************** */
	String USER_RENDERING_SERVICE = "USER_RENDERING_SERVICE";
	String FETCH_USER_SHEET = "FetchUser";
	String FETCH_USER = "/users";

	/* **************** Genre Service Resources **************** */
	String GENRE_SERVICE = "GENRE_SERVICE";
	String GENRE_SERVICE_SHEET = "GetGenreList";
	String GET_GENRE_LIST = "/getGenreList";

	/* **************** Get Geo Location Service Resources **************** */
	String GET_GEO_LOCATION = "GET_GEO_LOCATION";
	String GET_GEO_LOCATION_SHEET = "GetGeoLocation";
	String GET_LOCATION_BY_LAT_LONG = "/getLocationByLatLong";
	String GET_LOCATION_BY_IP = "/getLocationByIp";
	String GET_LOCATION_STATUS_BY_IP = "/getLocationStatus";
	String GET_LOCATION_BY_ADDRESS = "/getLocationByAddress";

	/* **************** Tag Chat Service Resources **************** */
	String TAG_CHAT_SERVICE = "TAG_CHAT_SERVICE";
	String USER_SECRET_ID = "39bc2bd2f6fd95102b34";
	String TAG_CHAT_MESSAGE = "/message";
	String TAG_CHAT_ID = "tagChat/2";
	String TAG_CHAT_NOTIFICATION = "/sendNotification";
	String TAG_CHAT_MEMBER_ID = "tagchat/1/members";
	String TAG_CHAT_USER_REPORT = "user/report";
	String TAG_CHAT_MESSAGE_REPORT = "message/report";

	/* **************** Notification Service Resources **************** */
	String NOTIFICATION_SERVICE = "NOTIFICATION_SERVICE";

	/* **************** Search Service Resources **************** */
	String SEARCH_SERVICE = "SEARCH_SERVICE";

	/* **************** Mood Service Resources **************** */
	String MOOD_SERVICE = "MOOD_SERVICE";
	String SET_MOOD_POSITIVE_SHEET = "SetMoodPositive";
	String SET_MOOD_NEGATIVE_SHEET = "SetMoodNegative";
	String GET_MOOD_SHEET = "GetMood";
	String VIEW_MOOD_SHEET = "ViewMood";
	String MOOD_REACTION_NEGATIVE_SHEET = "MoodReactionNegative";
	String DELETE_MOOD_SHEET = "DeleteMood";
	String MOOD_REACTION_MULTIPLE_USERS_SHEET = "MoodReactionMultipleUsers";
	String MOOD_REACTION_SINGLE_USER_SHEET = "MoodReactionSingleUser";
	String SET_MOOD = "/mood";
	String GET_MOOD = "/user/{UserId}/mood";
	String VIEW_MOOD = "/view/{moodId}";
	String MOOD_REACTION = "/reaction/{moodId}";
	String FETCH_VIEWERS = "/viewers/{moodId}";
	String DELETE_MOOD = "/mood/{:moodId}";

	/* **************** Config Service Resources **************** */
	String CONFIG_SERVICE = "CONFIG_SERVICE";
	String CONFIG_SERVICE_CHECK = "health";
	String CONFIG_SPLASH_SCREEN = "splashScreenConfig";
	String SPLASH_SCREEN_SHEET = "SplashScreenData";
	String CONFIG_AB_VARIANT = "/ab-test-service/v1.0.0/get-abtest-variant";
	String CONFIG_AB_VARIANT_SHEET = "ABvariantData";
	String CONFIG_USER_ID = "CONFIG_USER_ID";

	/* **************** Follow Service Resources **************** */
	String FOLLOW_SERVICE = "FOLLOW_SERVICE";
	String FOLLOW_SERVICE_FOLLOWERS = "follow-service/v1.0.0/getFollowers";
	String FOLLOW_SERVICE_FOLLOWEES = "follow-service/v1.0.0/getFollowees";
	String FOLLOW_SERVICE_FOLLOWERS_MAP = "follow-service/v1.0.0/getFollowerMap";
	String FOLLOW_SERVICE_FOLLOWEE_MAP = "follow-service/v1.0.0/getFolloweeMap";
	String USER_TO_FOLLOW = "follow-service/v1.0.0/follow/";
	String USER_TO_UNFOLLOW = "follow-service/v1.0.0/unfollow/";

	/* **************** Feedback Service Resources **************** */
	String FEEDBACK_SERVICE = "FEEDBACK_SERVICE";
	String APP_FEEDBACK = "/requestType90";
	String SURVEY_FEEDBACK = "/requestType82";
	String FAQ_FEEDBACK = "/faq";
	String FAQ_FEEDBACK_SHEET = "FaqFeedbackData";
	String FEEDBACK_FAQ_USER_ID = "FEEDBACK_USER_FAQ_ID";
	String FEEDBACK_FAQ_USER_ID_SECRET = "FEEDBACK_FAQ_USER_ID_SECRET";
	String FEEDBACK_USER_APP_RATING_SHEET = "AppFeedbackData";
	String FEEDBACK_SURVEY_FEEDBACK_SHEET = "SurveyFeedback";

	/* **************** Block Service Resources **************** */
	String BLOCK_SERVICE = "BLOCK_SERVICE";
	String BLOCK_USER_SHEET = "Block User";
	String BLOCK_USER = "/requestType74";

}