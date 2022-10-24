package ibs.lucene.demo

fun main(args: Array<String>) {

    if (args.isNullOrEmpty())
        throw IllegalArgumentException("Error. Index path is not specified")

    LuceneIndexWriter(args[0]).createIndex()

}