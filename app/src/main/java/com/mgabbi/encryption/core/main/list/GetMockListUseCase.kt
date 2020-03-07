package com.mgabbi.encryption.core.main.list

import com.mgabbi.encryption.data.models.MockItem
import com.mgabbi.encryption.data.repo.MockRepo
import com.mgabbi.encryption.shared.base.BaseUseCase
import com.mgabbi.encryption.shared.base.Result
import java.lang.Exception

class GetMockListUseCase(private val repo: MockRepo) : BaseUseCase<Unit, List<MockItem>>() {
    override suspend fun run(params: Unit): Result<List<MockItem>> {
        return try {
            Result.Success(repo.getMockList())
        } catch (ex: Exception) {
            Result.Error(ex)
        }
    }
}
