package com.liferay.gwenod.gd.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.gwenod.gd.rest.client.dto.v1_0.Document;
import com.liferay.gwenod.gd.rest.client.http.HttpInvoker;
import com.liferay.gwenod.gd.rest.client.pagination.Page;
import com.liferay.gwenod.gd.rest.client.resource.v1_0.DocumentResource;
import com.liferay.gwenod.gd.rest.client.serdes.v1_0.DocumentSerDes;
import com.liferay.petra.function.transform.TransformUtil;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author elbou
 * @generated
 */
@Generated("")
public abstract class BaseDocumentResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_documentResource.setContextCompany(testCompany);

		DocumentResource.Builder builder = DocumentResource.builder();

		documentResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Document document1 = randomDocument();

		String json = objectMapper.writeValueAsString(document1);

		Document document2 = DocumentSerDes.toDTO(json);

		Assert.assertTrue(equals(document1, document2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Document document = randomDocument();

		String json1 = objectMapper.writeValueAsString(document);
		String json2 = DocumentSerDes.toJSON(document);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Document document = randomDocument();

		document.setAddress(regex);
		document.setChangeLog(regex);
		document.setCity(regex);
		document.setDescription(regex);
		document.setFileEntryTypeIdName(regex);
		document.setFileName(regex);
		document.setMimeType(regex);
		document.setName(regex);
		document.setTitle(regex);
		document.setVersion(regex);

		String json = DocumentSerDes.toJSON(document);

		Assert.assertFalse(json.contains(regex));

		document = DocumentSerDes.toDTO(json);

		Assert.assertEquals(regex, document.getAddress());
		Assert.assertEquals(regex, document.getChangeLog());
		Assert.assertEquals(regex, document.getCity());
		Assert.assertEquals(regex, document.getDescription());
		Assert.assertEquals(regex, document.getFileEntryTypeIdName());
		Assert.assertEquals(regex, document.getFileName());
		Assert.assertEquals(regex, document.getMimeType());
		Assert.assertEquals(regex, document.getName());
		Assert.assertEquals(regex, document.getTitle());
		Assert.assertEquals(regex, document.getVersion());
	}

	@Test
	public void testCreateDocument() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testDeleteDocument() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetDocument() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testUpdateDocument() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetDocumentHistory() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetDocuments() throws Exception {
		Assert.assertTrue(false);
	}

	protected void assertContains(Document document, List<Document> documents) {
		boolean contains = false;

		for (Document item : documents) {
			if (equals(document, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			documents + " does not contain " + document, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Document document1, Document document2) {
		Assert.assertTrue(
			document1 + " does not equal " + document2,
			equals(document1, document2));
	}

	protected void assertEquals(
		List<Document> documents1, List<Document> documents2) {

		Assert.assertEquals(documents1.size(), documents2.size());

		for (int i = 0; i < documents1.size(); i++) {
			Document document1 = documents1.get(i);
			Document document2 = documents2.get(i);

			assertEquals(document1, document2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Document> documents1, List<Document> documents2) {

		Assert.assertEquals(documents1.size(), documents2.size());

		for (Document document1 : documents1) {
			boolean contains = false;

			for (Document document2 : documents2) {
				if (equals(document1, document2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				documents2 + " does not contain " + document1, contains);
		}
	}

	protected void assertValid(Document document) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (document.getAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("changeLog", additionalAssertFieldName)) {
				if (document.getChangeLog() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("city", additionalAssertFieldName)) {
				if (document.getCity() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("companyId", additionalAssertFieldName)) {
				if (document.getCompanyId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createDate", additionalAssertFieldName)) {
				if (document.getCreateDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (document.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileEntryId", additionalAssertFieldName)) {
				if (document.getFileEntryId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileEntryTypeId", additionalAssertFieldName)) {
				if (document.getFileEntryTypeId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"fileEntryTypeIdName", additionalAssertFieldName)) {

				if (document.getFileEntryTypeIdName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (document.getFileName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("folderId", additionalAssertFieldName)) {
				if (document.getFolderId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (document.getGroupId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mimeType", additionalAssertFieldName)) {
				if (document.getMimeType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("modifiedDate", additionalAssertFieldName)) {
				if (document.getModifiedDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (document.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("repositoryId", additionalAssertFieldName)) {
				if (document.getRepositoryId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("size", additionalAssertFieldName)) {
				if (document.getSize() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tags", additionalAssertFieldName)) {
				if (document.getTags() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (document.getTitle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (document.getType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (document.getUserId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("version", additionalAssertFieldName)) {
				if (document.getVersion() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Document> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<Document> page, Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<Document> documents = page.getItems();

		int size = documents.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);

		Map<String, Map<String, String>> actions = page.getActions();

		for (String key : expectedActions.keySet()) {
			Map action = actions.get(key);

			Assert.assertNotNull(key + " does not contain an action", action);

			Map expectedAction = expectedActions.get(key);

			Assert.assertEquals(
				expectedAction.get("method"), action.get("method"));
			Assert.assertEquals(expectedAction.get("href"), action.get("href"));
		}
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.liferay.gwenod.gd.rest.dto.v1_0.Document.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Document document1, Document document2) {
		if (document1 == document2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getAddress(), document2.getAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("changeLog", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getChangeLog(), document2.getChangeLog())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("city", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getCity(), document2.getCity())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("companyId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getCompanyId(), document2.getCompanyId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getCreateDate(), document2.getCreateDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getDescription(),
						document2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileEntryId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getFileEntryId(),
						document2.getFileEntryId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileEntryTypeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getFileEntryTypeId(),
						document2.getFileEntryTypeId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"fileEntryTypeIdName", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						document1.getFileEntryTypeIdName(),
						document2.getFileEntryTypeIdName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getFileName(), document2.getFileName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("folderId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getFolderId(), document2.getFolderId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getGroupId(), document2.getGroupId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("mimeType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getMimeType(), document2.getMimeType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("modifiedDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getModifiedDate(),
						document2.getModifiedDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getName(), document2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("repositoryId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getRepositoryId(),
						document2.getRepositoryId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("size", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getSize(), document2.getSize())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tags", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getTags(), document2.getTags())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getTitle(), document2.getTitle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getType(), document2.getType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getUserId(), document2.getUserId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("version", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						document1.getVersion(), document2.getVersion())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		return TransformUtil.transform(
			ReflectionUtil.getDeclaredFields(clazz),
			field -> {
				if (field.isSynthetic()) {
					return null;
				}

				return field;
			},
			java.lang.reflect.Field.class);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_documentResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_documentResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		if (entityModel == null) {
			return Collections.emptyList();
		}

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		return TransformUtil.transform(
			getEntityFields(),
			entityField -> {
				if (!Objects.equals(entityField.getType(), type) ||
					ArrayUtil.contains(
						getIgnoredEntityFieldNames(), entityField.getName())) {

					return null;
				}

				return entityField;
			});
	}

	protected String getFilterString(
		EntityField entityField, String operator, Document document) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("address")) {
			sb.append("'");
			sb.append(String.valueOf(document.getAddress()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("changeLog")) {
			sb.append("'");
			sb.append(String.valueOf(document.getChangeLog()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("city")) {
			sb.append("'");
			sb.append(String.valueOf(document.getCity()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("companyId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("createDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(document.getCreateDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(document.getCreateDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(document.getCreateDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(document.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fileEntryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileEntryTypeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileEntryTypeIdName")) {
			sb.append("'");
			sb.append(String.valueOf(document.getFileEntryTypeIdName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fileName")) {
			sb.append("'");
			sb.append(String.valueOf(document.getFileName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("folderId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("groupId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("mimeType")) {
			sb.append("'");
			sb.append(String.valueOf(document.getMimeType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("modifiedDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(document.getModifiedDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(document.getModifiedDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(document.getModifiedDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(document.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("repositoryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("size")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("tags")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("title")) {
			sb.append("'");
			sb.append(String.valueOf(document.getTitle()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("type")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("userId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("version")) {
			sb.append("'");
			sb.append(String.valueOf(document.getVersion()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Document randomDocument() throws Exception {
		return new Document() {
			{
				address = StringUtil.toLowerCase(RandomTestUtil.randomString());
				changeLog = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				city = StringUtil.toLowerCase(RandomTestUtil.randomString());
				companyId = RandomTestUtil.randomLong();
				createDate = RandomTestUtil.nextDate();
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fileEntryId = RandomTestUtil.randomLong();
				fileEntryTypeId = RandomTestUtil.randomLong();
				fileEntryTypeIdName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fileName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				folderId = RandomTestUtil.randomLong();
				groupId = RandomTestUtil.randomLong();
				mimeType = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				modifiedDate = RandomTestUtil.nextDate();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				repositoryId = RandomTestUtil.randomLong();
				size = RandomTestUtil.randomLong();
				title = StringUtil.toLowerCase(RandomTestUtil.randomString());
				userId = RandomTestUtil.randomLong();
				version = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Document randomIrrelevantDocument() throws Exception {
		Document randomIrrelevantDocument = randomDocument();

		return randomIrrelevantDocument;
	}

	protected Document randomPatchDocument() throws Exception {
		return randomDocument();
	}

	protected DocumentResource documentResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = _getSuperClass(source.getClass());

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					sourceClass.getDeclaredFields()) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				Method setMethod = _getMethod(
					targetClass, field.getName(), "set",
					getMethod.getReturnType());

				setMethod.invoke(target, getMethod.invoke(source));
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Class<?> _getSuperClass(Class<?> clazz) {
			Class<?> superClass = clazz.getSuperclass();

			if ((superClass == null) || (superClass == Object.class)) {
				return clazz;
			}

			return superClass;
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseDocumentResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.gwenod.gd.rest.resource.v1_0.DocumentResource
		_documentResource;

}