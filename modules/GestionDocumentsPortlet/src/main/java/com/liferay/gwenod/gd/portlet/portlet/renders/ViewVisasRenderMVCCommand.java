package com.liferay.gwenod.gd.portlet.portlet.renders;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.gwenod.gd.portlet.constants.GestionDocumentsPortletKeys;
import com.liferay.gwenod.gd.portlet.context.FileEntryManagementToolbarDisplayContext;
import com.liferay.gwenod.gd.service.service.GestionDocumentLocalService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
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
            addManagementToolbarAttributes(renderRequest, renderResponse);
            addVisaListAttributes(renderRequest);
        } catch (PortalException e) {
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

        String keywords = ParamUtil.getString(renderRequest, "keywords");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                DLFileEntry.class.getName(), renderRequest
        );

        String fileType = ParamUtil.getString(renderRequest, "filterByStatus");

        List<DLFileEntry> files = gestionDocumentLocalService.searchByKeywords(
                themeDisplay.getUserId(), keywords, fileType, start, end, serviceContext
        );

        renderRequest.setAttribute("files", files);

        renderRequest.setAttribute("count", files.size());

    }

    private void addManagementToolbarAttributes(
            RenderRequest renderRequest, RenderResponse renderResponse
    ) {
        LiferayPortletRequest liferayPortletRequest =
                portal.getLiferayPortletRequest(renderRequest);

        LiferayPortletResponse liferayPortletResponse =
                portal.getLiferayPortletResponse(renderResponse);

        FileEntryManagementToolbarDisplayContext fileEntryManagementToolbarDisplayContext =
                new FileEntryManagementToolbarDisplayContext(
                        liferayPortletRequest, liferayPortletResponse, portal.getHttpServletRequest(renderRequest)
                );

        renderRequest.setAttribute(
                "fileEntryManagementToolbarDisplayContext",
                fileEntryManagementToolbarDisplayContext
        );
    }
}
