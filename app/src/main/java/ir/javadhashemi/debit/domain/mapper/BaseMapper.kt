package ir.javadhashemi.debit.domain.mapper

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/06 10:02
 */
interface BaseMapper<in T, out R> {

    fun map(input: T): R

}