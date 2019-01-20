package ir.javadhashemi.debit.domain.usecase

import ir.javadhashemi.debit.domain.mapper.DebitEntityMapper
import ir.javadhashemi.debit.domain.repository.DebitRepository
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
//        val mock = mock<LiveData<List<DebitEntity>>>()
//        whenever(repository.getAllDebits(1)).thenReturn(mock)

        val result = getAllDebitsByType.execute(1)

//        assertThat(result, `is`((mock)))
    }
}