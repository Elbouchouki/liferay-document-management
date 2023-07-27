<%--<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>--%>
<%--<%@ page import="com.liferay.document.library.util.DLURLHelperUtil" %>--%>
<%--<%@ page import="com.liferay.document.library.kernel.service.DLAppServiceUtil" %>--%>
<%--<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>--%>
<%--<%@ page import="com.liferay.document.library.util.DLURLHelper" %>--%>
<%--<%@ page import="com.liferay.portal.kernel.repository.model.FileVersion" %>--%>
<%--<%@ page import="com.liferay.gwenod.gd.portlet.constants.GestionDocumentsPortletKeys" %>--%>
<%--<%@ include file="init.jsp" %>--%>

<%--<%--%>
<%--    FileEntryManagementToolbarDisplayContext fileEntryManagementToolbarDisplayContext =--%>
<%--            (FileEntryManagementToolbarDisplayContext) request.getAttribute("fileEntryManagementToolbarDisplayContext");--%>
<%--    Integer count = (Integer) request.getAttribute("count");--%>
<%--    List<DLFileEntry> files = (List<DLFileEntry>) request.getAttribute("files");--%>

<%--    Date fromDate = (Date) request.getAttribute("fromDateSearch");--%>
<%--    Date toDate = (Date) request.getAttribute("toDateSearch");--%>
<%--    String keywords = (String) request.getAttribute("keywords");--%>
<%--    String filterByStatus = (String) request.getAttribute("filterByStatus");--%>
<%--//--%>
<%--//    System.out.println("view fromDate : " + fromDate);--%>
<%--//    System.out.println("view toDate : " + toDate);--%>
<%--//    System.out.println("view keywords : " + keywords);--%>
<%--//    System.out.println("view filterByStatus : " + filterByStatus);--%>

<%--%>--%>


<%--<div class="container-fluid-1280">--%>


<%--    <clay:management-toolbar--%>
<%--            displayContext="<%= fileEntryManagementToolbarDisplayContext %>"--%>
<%--            selectable="false"--%>
<%--            itemsTotal="<%= count %>"--%>
<%--            searchContainerId="fileEntrySearchContainer"--%>
<%--    />--%>

<%--    <portlet:actionURL var="viewAllURL" name="<%=GestionDocumentsPortletKeys.MVCCommandNames.VIEW_ALL %>"/>--%>

<%--    <aui:form action="<%= viewAllURL %>" method="post" name="dateForm">--%>
<%--        <aui:fieldset>--%>
<%--            <aui:row>--%>
<%--                <aui:col span="6">--%>
<%--                    <aui:input title="label.dateFrom" label="label.dateFrom" name="fromDateSearch" type="date"--%>
<%--                               value="<%= fromDate %>"--%>
<%--                    />--%>
<%--                </aui:col>--%>
<%--                <aui:col span="6">--%>
<%--                    <aui:input title="label.dateTo" label="label.dateTo" name="toDateSearch" type="date"--%>
<%--                               value="<%= toDate %>"/>--%>
<%--                </aui:col>--%>
<%--            </aui:row>--%>
<%--            <aui:row>--%>
<%--                <aui:col span="2">--%>
<%--                    <aui:button type="submit" value="Search"/>--%>
<%--                </aui:col>--%>
<%--            </aui:row>--%>

<%--            <aui:input name="keywords" type="hidden" value="<%= keywords %>"/>--%>
<%--            <aui:input name="filterByStatus" type="hidden" value="<%= filterByStatus %>"/>--%>

<%--        </aui:fieldset>--%>

<%--    </aui:form>--%>

<%--    <liferay-ui:search-container--%>
<%--            id="fileEntrySearchContainer"--%>
<%--            emptyResultsMessage="fileEntry.empty"--%>
<%--            total="<%= count %>"--%>

<%--    >--%>
<%--        <liferay-ui:search-container-results results="<%= files %>"/>--%>

<%--        <liferay-ui:search-container-row--%>
<%--                className="com.liferay.document.library.kernel.model.DLFileEntry"--%>
<%--                modelVar="fileEntry">--%>

<%--            <%--%>
<%--                Date modifiedDate = fileEntry.getModifiedDate();--%>
<%--                DLFileVersion latestFileVersion = fileEntry.getLatestFileVersion(true);--%>
<%--                DLFileEntryType fileEntryType = fileEntry.getDLFileEntryType();--%>
<%--                String documentType = String.valueOf(fileEntryType.getName(Locale.getDefault()));--%>
<%--                FileEntry ff = DLAppServiceUtil.getFileEntry(--%>
<%--                        fileEntry.getFileEntryId()--%>
<%--                );--%>
<%--                FileVersion fileVersion = ff.getFileVersion();--%>
<%--                String thumbnailSrc = DLURLHelperUtil.getThumbnailSrc(--%>
<%--                        ff--%>
<%--                        , themeDisplay--%>
<%--                );--%>
<%--                String previewURL = DLURLHelperUtil.getPreviewURL(--%>
<%--                        ff, fileVersion, themeDisplay, ""--%>
<%--                );--%>

<%--            %>--%>

<%--            <c:choose>--%>
<%--                <c:when test='<%= fileEntryManagementToolbarDisplayContext.getDisplayStyle().equals("descriptive") %>'>--%>
<%--                    <liferay-ui:search-container-column-image src="<%= thumbnailSrc %>"/>--%>
<%--                    <liferay-ui:search-container-column-text colspan="<%=2%>">--%>
<%--                        <%--%>
<%--                            String modifiedDateDescription = LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - modifiedDate.getTime(), true);--%>
<%--                        %>--%>
<%--                        <h4>--%>
<%--                            <aui:a href='<%= "/documents/-/document_library/cbks/view_file/" + fileEntry.getFileEntryId() %>'>--%>
<%--                                <%= HtmlUtil.unescape(latestFileVersion.getTitle()) %>--%>
<%--                            </aui:a>--%>
<%--                        </h4>--%>
<%--                        <h5 class="text-default">--%>
<%--                            <liferay-ui:message--%>
<%--                                    arguments="<%=new String[] {latestFileVersion.getUserName(), modifiedDateDescription}%>"--%>
<%--                                    key="x-modified-x-ago"/>--%>
<%--                        </h5>--%>
<%--                    </liferay-ui:search-container-column-text>--%>
<%--                </c:when>--%>
<%--                <c:when test='<%= fileEntryManagementToolbarDisplayContext.getDisplayStyle().equals("icon") %>'>--%>
<%--                    <liferay-ui:search-container-column-text>--%>
<%--                        <div class="card-type-asset entry-display-style file-card form-check form-check-card form-check-top-left">--%>
<%--                            <div class="card">--%>
<%--                                <div class="aspect-ratio card-item-first">--%>
<%--                                    <div class="custom-checkbox custom-control">--%>
<%--                                        <label>--%>
<%--                                            <img alt=""--%>
<%--                                                 class="aspect-ratio-item-center-middle aspect-ratio-item-fluid"--%>
<%--                                                 src="<%= thumbnailSrc %>"/>--%>

<%--                                        </label>--%>
<%--                                    </div>--%>
<%--                                </div>--%>

<%--                                <div class="card-body">--%>
<%--                                    <div class="card-row">--%>
<%--                                        <div class="autofit-col autofit-col-expand">--%>
<%--                                            <aui:a cssClass="card-title text-truncate"--%>
<%--                                                   href='<%= "/documents/-/document_library/cbks/view_file/" + fileEntry.getFileEntryId() %>'--%>
<%--                                                   title="<%= HtmlUtil.escapeAttribute(latestFileVersion.getTitle()) %>">--%>
<%--                                                <%= latestFileVersion.getTitle() %>--%>
<%--                                            </aui:a>--%>

<%--                                            <div class="card-subtitle text-truncate">--%>
<%--                                                <%= LanguageUtil.format(request, "modified-x-ago-by-x", new String[]{LanguageUtil.getTimeDescription(locale, System.currentTimeMillis() - modifiedDate.getTime(), true), HtmlUtil.escape(latestFileVersion.getUserName())}, false) %>--%>
<%--                                            </div>--%>

<%--                                            <div class="card-detail">--%>
<%--                                                <aui:workflow-status markupView="lexicon" showIcon="<%= false %>"--%>
<%--                                                                     showLabel="<%= false %>"--%>
<%--                                                                     status="<%= latestFileVersion.getStatus() %>"/>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </liferay-ui:search-container-column-text>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <liferay-ui:search-container-column-image--%>
<%--                            name="‎"--%>
<%--                            src="<%= thumbnailSrc %>"/>--%>
<%--                    <liferay-ui:search-container-column-text--%>
<%--                            cssClass="table-cell-expand table-cell-minw-200"--%>
<%--                            name="title"--%>
<%--                    >--%>
<%--                        <div class="autofit-row">--%>
<%--                            <div class="autofit-col autofit-col-expand">--%>
<%--                                <div class="table-title">--%>
<%--                                    <aui:a href='<%= "/documents/-/document_library/cbks/view_file/" + fileEntry.getFileEntryId() %>'>--%>
<%--                                        <%= HtmlUtil.unescape(latestFileVersion.getTitle()) %>--%>
<%--                                    </aui:a>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                    </liferay-ui:search-container-column-text>--%>

<%--                    <liferay-ui:search-container-column-text--%>
<%--                            cssClass="table-cell-expand-smaller table-cell-minw-150"--%>
<%--                            name="document-type"--%>
<%--                            value="<%= documentType %>"--%>
<%--                    />--%>
<%--                    <liferay-ui:search-container-column-text--%>
<%--                            cssClass="table-cell-expand-smallest"--%>
<%--                            name="size"--%>
<%--                            value="<%= LanguageUtil.formatStorageSize(latestFileVersion.getSize(), locale) %>"--%>
<%--                    />--%>
<%--                    <liferay-ui:search-container-column-status--%>
<%--                            cssClass="table-cell-expand-smallest"--%>
<%--                            name="status"--%>
<%--                            status="<%= latestFileVersion.getStatus() %>"--%>
<%--                    />--%>

<%--                    <liferay-ui:search-container-column-date--%>
<%--                            cssClass="table-cell-expand-smallest table-cell-ws-nowrap"--%>
<%--                            name="modified-date"--%>
<%--                            value="<%= modifiedDate %>"--%>
<%--                    />--%>
<%--                    <liferay-ui:search-container-column-user--%>
<%--                            cssClass="table-cell-ws-nowrap"--%>
<%--                            name="Modified By"--%>
<%--                            userId="<%= latestFileVersion.getUserId() %>"--%>
<%--                    />--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--        </liferay-ui:search-container-row>--%>


<%--        <liferay-ui:search-iterator--%>
<%--                displayStyle="<%= fileEntryManagementToolbarDisplayContext.getDisplayStyle() %>"--%>
<%--                markupView="lexicon"--%>
<%--        />--%>
<%--    </liferay-ui:search-container>--%>

<%--</div>--%>

<%--<script type="text/javascript">--%>

<%--    $("#<portlet:namespace/>fromDateSearch").change(--%>
<%--        e => {--%>
<%--            console.log("date", new Date($("#<portlet:namespace/>fromDateSearch").val()))--%>
<%--            &lt;%&ndash;$("#<portlet:namespace/>dateForm").submit()&ndash;%&gt;--%>
<%--        }--%>
<%--    )--%>

<%--    $("#<portlet:namespace/>toDateSearch").change(--%>
<%--        e => {--%>
<%--            console.log("date", new Date($("#<portlet:namespace/>toDateSearch").val()))--%>
<%--            &lt;%&ndash;$("#<portlet:namespace/>dateForm").submit()&ndash;%&gt;--%>
<%--        }--%>
<%--    )--%>

<%--</script>--%>
