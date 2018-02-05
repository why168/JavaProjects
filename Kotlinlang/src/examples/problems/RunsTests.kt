package examples.problems

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * Copyright 2000-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Edwin.Wu
 * @version 2018/2/5 下午5:46
 * @since JDK1.8
 */
class RunsTests{

    @Test fun testRuns1() {
        runTest(0)
    }

    @Test fun testRuns2() {
        runTest(1, 1)
    }

    @Test fun testRuns3() {
        runTest(3, 1, 2, 3)
    }

    @Test fun testRuns4() {
        runTest(3, 1, 2, 2, 3)
    }

    @Test
    fun testRuns5() {
        runTest(3, 1, 1, 2, 3)
    }

    @Test fun testRuns6() {
        runTest(1, 1, 1, 1, 1)
    }

    @Test fun testRuns7() {
        runTest(3, 1, 1, 1, 0, 1, 1)
    }

    @Test fun testRuns8() {
        runTest(3, 1, 1, 1, 0, 1)
    }

    @Test fun testRuns9() {
        runTest(5, 1, 0, 1, 0, 1)
    }
}

fun runTest(expected: Int, vararg data: Int) {
    assertEquals(expected, runs(data), "\ndata = ${Arrays.toString(data)}")
}