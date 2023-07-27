<%@ page import="com.liferay.gwenod.gd.portlet.constants.GestionDocumentsPortletKeys" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppServiceUtil" %>
<%@ page import="com.liferay.document.library.util.DLURLHelperUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileVersion" %>
<%@ include file="init.jsp" %>

<%
    Integer count = (Integer) request.getAttribute("count");
    List<DLFileEntry> files = (List<DLFileEntry>) request.getAttribute("files");
    String fromDate = (String) request.getAttribute("fromDate");
    String toDate = (String) request.getAttribute("toDate");
    String keywords = (String) request.getAttribute("keywords");
    String fileType = (String) request.getAttribute("fileType");
    String displayStyle = (String) request.getAttribute("displayStyle");
    System.out.println(displayStyle);
%>


<portlet:renderURL var="searchRenderURL">
    <portlet:param
            name="mvcRenderCommandName"
            value="<%=GestionDocumentsPortletKeys.MVCCommandNames.VIEW_ALL %>"
    />
</portlet:renderURL>

<div class="container-fluid-1280">
    <aui:form action="${searchRenderURL}" method="post" name="fm">
        <aui:fieldset>
            <aui:row>
                <aui:col span="10">
                    <aui:input name="keywords" label="label.keywords" placeholder="label.keywords.hint"
                               value="<%= keywords %>"
                               type="text"/>
                </aui:col>
                <aui:col span="2" cssClass="align-right justify-end align-items-end">
                    <aui:select name="displayStyle" label="label.displayStyle" value="<%= displayStyle %>"
                                onChange="submit()">
                        <aui:option label="label.displayStyle.icon" value="icon"/>
                        <aui:option label="label.displayStyle.list" value="list"/>
                        <aui:option label="label.displayStyle.descriptive" value="descriptive"/>
                    </aui:select>
                </aui:col>
            </aui:row>
            <aui:row>
                <aui:col span="4">
                    <aui:select name="fileType" label="label.fileType" value="<%= fileType %>" onChange="submit()">
                        <aui:option label="label.fileType.all" value="ALL"/>
                        <aui:option label="label.fileType.poa" value="POA"/>
                        <aui:option label="label.fileType.poi" value="POI"/>
                    </aui:select>
                </aui:col>
                <aui:col span="4">
                    <aui:input name="fromDate" label="label.dateFrom" value="<%= fromDate %>" type="date"
                               onChange="submit()"/>
                </aui:col>
                <aui:col span="4">
                    <aui:input name="toDate" label="label.dateTo" value="<%= toDate %>" type="date"
                               onChange="submit()"/>
                </aui:col>
            </aui:row>
        </aui:fieldset>
        <aui:fieldset>
            <aui:row>
                <aui:col span="4" cssClass="align-right justify-end align-items-end">
                    <aui:button cssClass="btn btn-mini btn-primary" type="submit" name="Search"
                                value="label.search"/>
                </aui:col>
            </aui:row>
        </aui:fieldset>
    </aui:form>


    <liferay-ui:search-container
            emptyResultsMessage=" fileEntry.empty"
            total="<%= count %>"
    >

        <liferay-ui:search-container-results results="<%= files %>"/>
        <liferay-ui:search-container-row
                className="com.liferay.document.library.kernel.model.DLFileEntry"
                modelVar="fileEntry">

            <%
                Date modifiedDate = fileEntry.getModifiedDate();
                DLFileVersion latestFileVersion = fileEntry.getLatestFileVersion(true);
                DLFileEntryType fileEntryType = fileEntry.getDLFileEntryType();
                String documentType = String.valueOf(fileEntryType.getName(Locale.getDefault()));
                FileEntry ff = DLAppServiceUtil.getFileEntry(
                        fileEntry.getFileEntryId()
                );
                FileVersion fileVersion = ff.getFileVersion();
                String thumbnailSrc = DLURLHelperUtil.getThumbnailSrc(
                        ff
                        , themeDisplay
                );
                String previewURL = DLURLHelperUtil.getPreviewURL(
                        ff, fileVersion, themeDisplay, ""
                );

            %>

            <c:choose>
                <c:when test='<%= displayStyle.equals("descriptive") %>'>
                    <liferay-ui:search-container-column-image src="<%= thumbnailSrc %>"/>
                    <liferay-ui:search-container-column-text colspan="<%=2%>">
                        <%
                            String modifiedDateDescription = LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - modifiedDate.getTime(), true);
                        %>
                        <h4>
                            <aui:a href='<%= "/documents/-/document_library/cbks/view_file/" + fileEntry.getFileEntryId() %>'>
                                <%= HtmlUtil.unescape(latestFileVersion.getTitle()) %>
                            </aui:a>
                        </h4>
                        <h5 class="text-default">
                            <liferay-ui:message
                                    arguments="<%=new String[] {latestFileVersion.getUserName(), modifiedDateDescription}%>"
                                    key="x-modified-x-ago"/>
                        </h5>
                    </liferay-ui:search-container-column-text>
                </c:when>
                <c:when test='<%= displayStyle.equals("icon") %>'>
                    <liferay-ui:search-container-column-text>
                        <div class="card-type-asset entry-display-style file-card form-check form-check-card form-check-top-left">
                            <div class="card">
                                <div class="aspect-ratio card-item-first">
                                    <div class="custom-checkbox custom-control">
                                        <label>
                                            <img alt=""
                                                 class="aspect-ratio-item-center-middle aspect-ratio-item-fluid"
                                                 src="<%= thumbnailSrc %>"/>

                                        </label>
                                    </div>
                                </div>

                                <div class="card-body">
                                    <div class="card-row">
                                        <div class="autofit-col autofit-col-expand">
                                            <aui:a cssClass="card-title text-truncate"
                                                   href='<%= "/documents/-/document_library/cbks/view_file/" + fileEntry.getFileEntryId() %>'
                                                   title="<%= HtmlUtil.escapeAttribute(latestFileVersion.getTitle()) %>">
                                                <%= latestFileVersion.getTitle() %>
                                            </aui:a>

                                            <div class="card-subtitle text-truncate">
                                                <%= LanguageUtil.format(request, "modified-x-ago-by-x", new String[]{LanguageUtil.getTimeDescription(locale, System.currentTimeMillis() - modifiedDate.getTime(), true), HtmlUtil.escape(latestFileVersion.getUserName())}, false) %>
                                            </div>

                                            <div class="card-detail">
                                                <aui:workflow-status markupView="lexicon" showIcon="<%= false %>"
                                                                     showLabel="<%= false %>"
                                                                     status="<%= latestFileVersion.getStatus() %>"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </liferay-ui:search-container-column-text>
                </c:when>
                <c:otherwise>
                    <liferay-ui:search-container-column-image
                            name="‎"
                            src="<%= thumbnailSrc %>"/>
                    <liferay-ui:search-container-column-text
                            cssClass="table-cell-expand table-cell-minw-200"
                            name="title"
                    >
                        <div class="autofit-row">
                            <div class="autofit-col autofit-col-expand">
                                <div class="table-title">
                                    <aui:a href='<%= "/documents/-/document_library/cbks/view_file/" + fileEntry.getFileEntryId() %>'>
                                        <%= HtmlUtil.unescape(latestFileVersion.getTitle()) %>
                                    </aui:a>
                                </div>
                            </div>
                        </div>

                    </liferay-ui:search-container-column-text>

                    <liferay-ui:search-container-column-text
                            cssClass="table-cell-expand-smaller table-cell-minw-150"
                            name="document-type"
                            value="<%= documentType %>"
                    />
                    <liferay-ui:search-container-column-text
                            cssClass="table-cell-expand-smallest"
                            name="size"
                            value="<%= LanguageUtil.formatStorageSize(latestFileVersion.getSize(), locale) %>"
                    />
                    <liferay-ui:search-container-column-status
                            cssClass="table-cell-expand-smallest"
                            name="status"
                            status="<%= latestFileVersion.getStatus() %>"
                    />

                    <liferay-ui:search-container-column-date
                            cssClass="table-cell-expand-smallest table-cell-ws-nowrap"
                            name="modified-date"
                            value="<%= modifiedDate %>"
                    />
                    <liferay-ui:search-container-column-user
                            cssClass="table-cell-ws-nowrap"
                            name="Modified By"
                            userId="<%= latestFileVersion.getUserId() %>"
                    />
                </c:otherwise>
            </c:choose>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator
                displayStyle="<%= displayStyle %>"
                markupView="lexicon"
        />
    </liferay-ui:search-container>
</div>

<script type="text/javascript">
    function submit() {
        $("form[name='<portlet:namespace/>fm']").submit();
    }
</script>