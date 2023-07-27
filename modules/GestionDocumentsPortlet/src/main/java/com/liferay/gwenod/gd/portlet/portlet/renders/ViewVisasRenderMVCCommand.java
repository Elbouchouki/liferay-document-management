package com.liferay.gwenod.gd.portlet.portlet.renders;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.gwenod.gd.portlet.constants.GestionDocumentsPortletKeys;
import com.liferay.gwenod.gd.service.service.GestionDocumentLocalService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + GestionDocumentsPortletKeys.GESTIONDOCUMENTS,
                "mvc.command.name=/",
                "mvc.command.name=" + GestionDocumentsPortletKeys.MVCCommandNames.VIEW_ALL
        },
        service = MVCRenderCommand.class
)
public class ViewVisasRenderMVCCommand implements MVCRenderCommand {

    @Reference
    private Portal portal;

    @Reference
    private GestionDocumentLocalService gestionDocumentLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        try {
            addVisaListAttributes(renderRequest);
        } catch (PortalException e) {
            System.out.println("error : " + e.getMessage());
            throw new RuntimeException(e);
        }
        return GestionDocumentsPortletKeys.MVCPaths.VIEW_ALL;
    }


    private void addVisaListAttributes(
            RenderRequest renderRequest
    ) throws PortalException {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        int currentPage = ParamUtil.getInteger(
                renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
                SearchContainer.DEFAULT_CUR);
        int delta = ParamUtil.getInteger(
                renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
                SearchContainer.DEFAULT_DELTA);
        int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
        int end = start + delta;
        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                DLFileEntry.class.getName(), renderRequest
        );
        String keywords = ParamUtil.getString(renderRequest, "keywords");
        String fileType = ParamUtil.getString(renderRequest, "fileType");

        String displayStyle = ParamUtil.getString(
                renderRequest, "displayStyle", "icon");

        String fromDate = ParamUtil.getString(renderRequest, "fromDate", null);
        String toDate = ParamUtil.getString(renderRequest, "toDate", null);

        List<DLFileEntry> files = gestionDocumentLocalService.searchByKeywords(
                themeDisplay.getUserId(), keywords, fileType,
                start, end,
                fromDate, toDate,
                serviceContext
        );

        renderRequest.setAttribute("files", files);
        renderRequest.setAttribute("count", files.size());
        renderRequest.setAttribute("fromDate", fromDate);
        renderRequest.setAttribute("toDate", toDate);
        renderRequest.setAttribute("keywords", keywords);
        renderRequest.setAttribute("fileType", fileType);
        renderRequest.setAttribute("displayStyle", displayStyle);
    }

}
