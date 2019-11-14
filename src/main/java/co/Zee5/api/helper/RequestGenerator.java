package co.Zee5.api.helper;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.logging.Logger;

import co.Zee5.api.config.Constants;
import io.restassured.specification.RequestSpecification;

/**
 * @author Dheeraj
 *
 */
public class RequestGenerator extends RestBaseClass implements Constants {

	static String sourceClass = RequestGenerator.class.getName();
	static Logger LOGGER = Logger.getLogger(sourceClass);
	String sourceMethod;

	RequestSpecification requestSpecification;

	/**
	 * @author Ooviya
	 * @param baseUri
	 * @return RequestSpecification
	 */
	public RequestSpecification getRequest(String baseUri) {
		sourceMethod = "getRequest";
		LOGGER.entering(sourceClass, sourceMethod);

		try {
			LOGGER.info("baseUri " + baseUri);
			requestSpecification = given().contentType(APPLICATION_JSON)
					.baseUri(PropertyReader.getPropertyValue(URL_PROPERTIES_PATH, baseUri));
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.exiting(sourceClass, sourceMethod);
		return requestSpecification;
	}

	/**
	 * @author Ooviya
	 * @param baseUri
	 * @param request
	 * @return RequestSpecification
	 */
	public RequestSpecification getRequest(String baseUri, Object request) {
		sourceMethod = "getRequest";
		LOGGER.entering(sourceClass, sourceMethod);

		try {
			LOGGER.info("baseUri " + baseUri);
			LOGGER.info("request " + request.toString());
			requestSpecification = given().contentType(APPLICATION_JSON)
					.baseUri(PropertyReader.getPropertyValue(URL_PROPERTIES_PATH, baseUri)).body(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("requestSpecification : " + requestSpecification);
		LOGGER.exiting(sourceClass, sourceMethod);
		return requestSpecification;

	}

	/**
	 * @author Ooviya
	 * @param header
	 * @param baseUri
	 * @return RequestSpecification
	 */
	public RequestSpecification getRequest(Map<String, String> header, String baseUri) {
		sourceMethod = "getRequest";
		LOGGER.entering(sourceClass, sourceMethod);
		try {
			LOGGER.info("baseUri " + baseUri);
			LOGGER.info("header " + header);

			requestSpecification = given().contentType(APPLICATION_JSON)
					.baseUri(PropertyReader.getPropertyValue(URL_PROPERTIES_PATH, baseUri)).headers(header);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.exiting(sourceClass, sourceMethod);
		return requestSpecification;
	}

	/**
	 * @param header
	 * @param baseUri
	 * @param request
	 * @return RequestSpecification
	 */
	public RequestSpecification getRequest(Map<String, String> header, String baseUri, Object request) {
		sourceMethod = "getRequest";
		LOGGER.entering(sourceClass, sourceMethod);
		try {
			LOGGER.info("baseUri " + baseUri);
			LOGGER.info("request " + request.toString());
			LOGGER.info("header " + header);

			requestSpecification = given().contentType(APPLICATION_JSON)
					.baseUri(PropertyReader.getPropertyValue(URL_PROPERTIES_PATH, baseUri)).headers(header)
					.body(request);

		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.exiting(sourceClass, sourceMethod);
		return requestSpecification;
	}

	/**
	 * @author Ooviya
	 * @param baseUri
	 * @param queryParam
	 * @return RequestSpecification
	 */
	public RequestSpecification getRequest(String baseUri, Map<String, String> queryParam) {
		sourceMethod = "getRequest";
		LOGGER.entering(sourceClass, sourceMethod);
		try {
			LOGGER.info("baseUri " + baseUri);
			LOGGER.info("queryParam " + queryParam);
			requestSpecification = given().contentType(APPLICATION_JSON)
					.baseUri(PropertyReader.getPropertyValue(URL_PROPERTIES_PATH, baseUri)).queryParams(queryParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.exiting(sourceClass, sourceMethod);
		return requestSpecification;
	}

	/**
	 * @author Ooviya
	 * @param baseUri
	 * @param request
	 * @param queryParam
	 * @return RequestSpecification
	 */
	public RequestSpecification getRequest(String baseUri, Object request, Map<String, String> queryParam) {
		sourceMethod = "getRequest";
		LOGGER.entering(sourceClass, sourceMethod);
		try {
			LOGGER.info("baseUri " + baseUri);
			LOGGER.info("request " + request.toString());
			LOGGER.info("queryParam " + queryParam);

			requestSpecification = given().contentType(APPLICATION_JSON)
					.baseUri(PropertyReader.getPropertyValue(URL_PROPERTIES_PATH, baseUri)).queryParams(queryParam)
					.body(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.exiting(sourceClass, sourceMethod);
		return requestSpecification;

	}
	/**
	 * @author Ooviya
	 * @param baseUri
	 * @param pathParam
	 * @param request
	 * @return
	 */
	public RequestSpecification getRequest(String baseUri, Map<String, String> pathParam, Object request) {
		sourceMethod = "getRequest";
		LOGGER.entering(sourceClass, sourceMethod);
		try {
			LOGGER.info("baseUri " + baseUri);
			LOGGER.info("request " + request.toString());
			LOGGER.info("queryParam " + pathParam);

			requestSpecification = given().contentType(APPLICATION_JSON)
					.baseUri(PropertyReader.getPropertyValue(URL_PROPERTIES_PATH, baseUri)).pathParams(pathParam)
					.body(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.exiting(sourceClass, sourceMethod);
		return requestSpecification;

	}

	/**
	 * @author Ooviya
	 * @param header
	 * @param baseUri
	 * @param pathParam
	 * @return RequestSpecification
	 */
	public RequestSpecification getRequest(Map<String, String> header, String baseUri, Map<String, String> pathParam) {
		sourceMethod = "getRequest";
		LOGGER.entering(sourceClass, sourceMethod);
		try {
			LOGGER.info("baseUri " + baseUri);
			LOGGER.info("header " + header);
			LOGGER.info("pathParam " + pathParam);

			requestSpecification = given().contentType(APPLICATION_JSON)
					.baseUri(PropertyReader.getPropertyValue(URL_PROPERTIES_PATH, baseUri)).headers(header)
					.pathParams(pathParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.exiting(sourceClass, sourceMethod);
		return requestSpecification;
	}

	/**
	 * @author Ooviya
	 * @param header
	 * @param baseUri
	 * @param queryParam
	 * @param pathParam
	 * @return RequestSpecification
	 */
	public RequestSpecification getRequest(Map<String, String> header, String baseUri, Map<String, String> queryParam,
			Map<String, String> pathParam) {
		sourceMethod = "getRequest";
		LOGGER.entering(sourceClass, sourceMethod);
		try {
			LOGGER.info("baseUri " + baseUri);
			LOGGER.info("header " + header);
			LOGGER.info("queryParam " + queryParam);
			LOGGER.info("pathParam " + pathParam);

			requestSpecification = given().contentType(APPLICATION_JSON)
					.baseUri(PropertyReader.getPropertyValue(URL_PROPERTIES_PATH, baseUri)).headers(header)
					.queryParams(queryParam).pathParams(pathParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.exiting(sourceClass, sourceMethod);
		return requestSpecification;

	}
}