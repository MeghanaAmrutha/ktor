package com.example.utils

import com.example.repositoryTesting.RepositoryTesting
import com.example.routeTesting.RouteTesting
import com.example.serviceTesting.ServiceTesting
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
    @Suite.SuiteClasses(
        RouteTesting::class,
        ServiceTesting::class,
        RepositoryTesting::class
    )
class TestSuiteClass