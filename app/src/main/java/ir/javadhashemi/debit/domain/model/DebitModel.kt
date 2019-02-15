package ir.javadhashemi.debit.domain.model

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/06 10:00
 */
data class DebitModel(
        var localId: Int = 0,
        var type: Int = 0,
        var name: String = "",
        var desc: String? = "",
        var cost: Int = 0,
        var returnedMoney: Int = 0,
        var startDate: String = "",
        var hasDeadLine: Boolean = false,
        var endDate: String = "",
        var isDone: Boolean = false
)