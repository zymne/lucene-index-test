package ibs.lucene.demo

import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.store.FSDirectory
import java.nio.file.Path

class LuceneIndexWriter(private val indexPath: String) {

    private lateinit var indexWriter: IndexWriter

    fun createIndex() {
        openIndex()
        addDocuments()
        finish()
    }

    private fun finish() {
        indexWriter.commit()
        indexWriter.close()
    }

    /**
     * Add documents to the index
     */
    private fun addDocuments() {
        val doc = Document()
        // jdk-8u333-windows-x64.exe
        doc.add(StringField("title", "jdk8u333", Field.Store.NO))
        doc.add(StringField("documentUrl", "https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html#license-lightbox", Field.Store.NO))
        indexWriter.addDocument(doc)
    }

    private fun openIndex(): Boolean {
        val fsDirectory: FSDirectory = FSDirectory.open(Path.of(indexPath))
        val analyzer = StandardAnalyzer()
        val indexConf = IndexWriterConfig(analyzer)
        indexWriter = IndexWriter(fsDirectory, indexConf)
        return true
    }

}