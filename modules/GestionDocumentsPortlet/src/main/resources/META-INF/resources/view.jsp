<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ include file="init.jsp" %>

<%
    FileEntryManagementToolbarDisplayContext fileEntryManagementToolbarDisplayContext =
            (FileEntryManagementToolbarDisplayContext) request.getAttribute("fileEntryManagementToolbarDisplayContext");
    Integer count = (Integer) request.getAttribute("count");
    List<DLFileEntry> files = (List<DLFileEntry>) request.getAttribute("files");
%>


<div class="container-fluid-1280">


    <clay:management-toolbar
            displayContext="<%= fileEntryManagementToolbarDisplayContext %>"
            selectable="false"
            itemsTotal="<%= count %>"
            searchContainerId="fileEntrySearchContainer"
    />

    <liferay-ui:search-container
            id="fileEntrySearchContainer"
            emptyResultsMessage="fileEntry.empty"
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
            %>

            <liferay-ui:search-container-column-text
                    cssClass="table-cell-expand table-cell-minw-100"
                    name="title"
            >
                <div class="autofit-row">
                    <div class="autofit-col">
                        <clay:icon symbol="documents-and-media"/>
                    </div>
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
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator
                displayStyle="<%= fileEntryManagementToolbarDisplayContext.getDisplayStyle() %>"
                markupView="lexicon"
        />
    </liferay-ui:search-container>

</div>
