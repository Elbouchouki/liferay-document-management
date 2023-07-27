package com.liferay.gwenod.gd.service.internal.search.spi.model.index.contributor;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.document.library.kernel.model.DLFileEntry",
        service = ModelDocumentContributor.class
)
public class DlFileEntryModelDocumentContributor implements ModelDocumentContributor<DLFileEntry> {
    @Override
    public void contribute(Document document, DLFileEntry dlFileEntry) {

        // Strip HTML.

        String description = HtmlUtil.escape(dlFileEntry.getDescription());
//        document.addText(Field.DESCRIPTION, description);

        String title = HtmlUtil.escape(dlFileEntry.getTitle());
//        document.addText(Field.TITLE, title);

//        document.addDate(Field.MODIFIED_DATE, dlFileEntry.getModifiedDate());

        // Handle localized fields.

        for (Locale locale : LanguageUtil.getAvailableLocales(
                dlFileEntry.getGroupId())) {

            String languageId = LocaleUtil.toLanguageId(locale);

            document.addText(
                    LocalizationUtil.getLocalizedName(
                            Field.DESCRIPTION, languageId),
                    description);
            document.addText(
                    LocalizationUtil.getLocalizedName(Field.TITLE, languageId),
                    title);
        }
    }

}
