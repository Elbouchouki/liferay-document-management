package com.liferay.gwenod.gd.rest.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author elbou
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/GestionDocumentsRest",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=GestionDocumentsRest"
	},
	service = Application.class
)
@Generated("")
public class GestionDocumentsRestApplication extends Application {
}