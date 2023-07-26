package com.liferay.gwenod.gd.portlet.portlet;

import com.liferay.gwenod.gd.portlet.constants.GestionDocumentsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.annotations.RenderMethod;

import org.osgi.service.component.annotations.Component;

/**
 * @author elbou
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=GestionDocuments",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=GestionDocuments",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + GestionDocumentsPortletKeys.GESTIONDOCUMENTS,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class GestionDocumentsPortlet extends MVCPortlet {

    @RenderMethod(portletNames = "com_liferay_gwenod_gd_portlet_GestionDocumentsPortlet")
    public String render() {

        return "/view.jsp";
    }

}