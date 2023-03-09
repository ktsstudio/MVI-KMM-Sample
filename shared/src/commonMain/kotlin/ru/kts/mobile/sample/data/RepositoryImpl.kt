package ru.kts.mobile.sample.data

import kotlin.random.Random
import kotlinx.coroutines.delay
import ru.kts.mobile.sample.common.Response
import ru.kts.mobile.sample.domain.api.model.UserInfo

internal class RepositoryImpl(
    // Data sources, mappers, etc.
) : Repository {

    override suspend fun getUserInfo(): Response<UserInfo> {
        delay(1500L)

        return when (Random.nextInt(from = 1, until = 5)) {
            1, 2, 3 -> Response.Success(
                data = UserInfo(
                    name = listOf("John", "Sasha", "Vova", "Peter").random(),
                    surname = listOf("Wick", "Ivanov", "Monzikov", "Britt").random(),
                    birthDay = listOf("20.10.1999", "02.07.2005", "17.02.1997").random(),
                    gender = listOf("Male", "Female").random(),
                ),
            )
            else -> Response.Failed(IllegalStateException("Sample exception"))
        }
    }
}
