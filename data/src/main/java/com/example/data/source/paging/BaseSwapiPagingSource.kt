package com.example.data.source.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.api.SwapiApi

open class BasePagingSource<T : Any>(
    private val swapiApi: SwapiApi,
    private val apiFunction: suspend (SwapiApi, Int) -> PageInfo<T>
) : PagingSource<Int, T>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        try {
            val nextPageNumber = params.key ?: 1
            val (values, prev, next) = apiFunction(swapiApi, nextPageNumber)

            return LoadResult.Page(
                data = values,
                prevKey = prev,
                nextKey = next
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    data class PageInfo<T>(
        val values: List<T>,
        val prevPage: Int?,
        val nextPage: Int?
    )
}