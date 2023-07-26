package com.liferay.gwenod.gd.service.internal.search.spi.model.index.contributor;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.document.library.kernel.model.DLFileEntry",
        service = ModelIndexerWriterContributor.class
)
public class DLFileEntryModelIndexerWriterContributor implements ModelIndexerWriterContributor<DLFileEntry> {
    @Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod(
                (DLFileEntry dlFileEntry) -> {
                    Document document =
                            modelIndexerWriterDocumentHelper.getDocument(dlFileEntry);

                    batchIndexingActionable.addDocuments(document);
                });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {

        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
                dlFileEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(DLFileEntry dlFileEntry) {
        return dlFileEntry.getCompanyId();
    }

    @Reference
    protected DLFileEntryLocalService dlFileEntryLocalService;

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

}
