package ir.javadhashemi.debit.domain.usecase

import android.arch.lifecycle.LiveData
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import ir.javadhashemi.debit.data.entity.DebitEntity
import ir.javadhashemi.debit.domain.mapper.DebitEntityMapper
import ir.javadhashemi.debit.domain.model.DebitModel
import ir.javadhashemi.debit.domain.repository.DebitRepository
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/10 09:54
 */

@RunWith(MockitoJUnitRunner::class)
class GetAllDebitsByTypeUseCaseTest {

    @Mock
    lateinit var repository: DebitRepository

    @Mock
    lateinit var mapper: DebitEntityMapper

    @InjectMocks
    lateinit var getAllDebitsByType: GetAllDebitsByTypeUseCase

    @Test
    fun shouldGetDebitModelListFromRepository() {
        val mock = mock<LiveData<List<DebitEntity>>>()
        whenever(repository.getAllDebits(1)).thenReturn(mock)

        val result = getAllDebitsByType.execute(1)

//        assertThat(result, `is`((mock)))
    }
}