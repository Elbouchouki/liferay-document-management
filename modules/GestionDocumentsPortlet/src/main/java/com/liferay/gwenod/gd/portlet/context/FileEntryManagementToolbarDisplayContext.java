package com.liferay.gwenod.gd.portlet.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.gwenod.gd.portlet.constants.GestionDocumentsPortletKeys;
import com.liferay.gwenod.gd.portlet.portlet.GestionDocumentsPortlet;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FileEntryManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext {
    private final ThemeDisplay themeDisplay;
    private final PortalPreferences portalPreferences;

    public FileEntryManagementToolbarDisplayContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            HttpServletRequest httpServletRequest
    ) {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse);
        themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
        portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
                liferayPortletRequest);
    }

    @Override
    public String getClearResultsURL() {
        return getSearchActionURL();
    }

//    public List<DropdownItem> getActionDropdownItems(
//            DLFileEntry fileEntry
//    ) {
//        return new DropdownItemList() {
//            {
//                add(
//                        dropdownItem -> {
//                            dropdownItem.setActive(true);
//                            dropdownItem.setHref(
//                                    "/web" + themeDisplay.getURLCurrent());
//                            dropdownItem.setLabel("All");
//                        });
//            }
//        };
//    }

//    public List<DropdownItem> getActionDropdownItems() {
//        return new DropdownItemList() {
//            {
//                add(
//                        dropdownItem -> {
//                            dropdownItem.setHref(
//                                    "/web" + themeDisplay.getURLCurrent());
//                            dropdownItem.setLabel("View in Site");
//                        });
//            }
//        };
//    }


    public String getDisplayStyle() {

        String displayStyle = ParamUtil.getString(request, "displayStyle");

        if (Validator.isNull(displayStyle)) {
            displayStyle = portalPreferences.getValue(GestionDocumentsPortletKeys.GESTIONDOCUMENTS,
                    "assignments-display-style",
                    "list");
        } else {
            portalPreferences.setValue(
                    GestionDocumentsPortletKeys.GESTIONDOCUMENTS, "assignments-display-style",
                    displayStyle);

            request.setAttribute(
                    WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
        }

        return displayStyle;
    }


    public String getFilterByStatus() {
        return ParamUtil.getString(request, "filterByStatus", "all");
    }

    @Override
    public List<DropdownItem> getFilterDropdownItems() {
        return new DropdownItemList() {
            {
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    "ALL".equals(getFilterByStatus())
                            );
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "filterByStatus", "ALL");
                            dropdownItem.setLabel("All");
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    "POA".equals(getFilterByStatus()));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "filterByStatus", "POA");
                            dropdownItem.setLabel("POA");
                        });
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(
                                    "POI".equals(getFilterByStatus()));
                            dropdownItem.setHref(
                                    _getCurrentSortingURL(), "filterByStatus", "POI");
                            dropdownItem.setLabel("POI");
                        });
            }
        };
    }

    private PortletURL _getCurrentSortingURL() throws PortletException {
        PortletURL sortingURL = PortletURLUtil.clone(
                currentURLObj, liferayPortletResponse);

        sortingURL.setParameter(
                "mvcRenderCommandName", GestionDocumentsPortletKeys.MVCCommandNames.VIEW_ALL);

        // Reset current page.
        sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");

        String keywords = ParamUtil.getString(request, "keywords");

        if (Validator.isNotNull(keywords)) {
            sortingURL.setParameter("keywords", keywords);
        }

        return sortingURL;
    }

    public String getSearchActionURL() {

        PortletURL searchURL = liferayPortletResponse.createRenderURL();

        searchURL.setProperty(
                "mvcRenderCommandName", GestionDocumentsPortletKeys.MVCCommandNames.VIEW_ALL);

        return searchURL.toString();
    }

}
