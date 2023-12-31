<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>


<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.document.library.kernel.model.DLFileVersion" %>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntryType" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Date" %>

<liferay-theme:defineObjects/>

<portlet:defineObjects/>