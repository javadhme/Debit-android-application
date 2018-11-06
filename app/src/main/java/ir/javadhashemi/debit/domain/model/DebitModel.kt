package ir.javadhashemi.debit.domain.model

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/06 10:00
 */
data class DebitModel(
        var localId: Int,
        var type: Int,
        var name: String,
        var desc: String,
        var cost: Int,
        var returnedMoney: Int,
        var startDate: Int,
        var endDate: Int,
        var isDone: Boolean
)