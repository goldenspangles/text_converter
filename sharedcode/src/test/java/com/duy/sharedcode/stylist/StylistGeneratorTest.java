/*
 * Copyright (c) 2017 by Tran Le Duy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duy.sharedcode.stylist;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Duy on 08-Aug-17.
 */
public class StylistGeneratorTest extends TestCase {
    public void testGenerate() throws Exception {
        ArrayList<String> generate = new StylistGenerator().generate("package com.duy.sharedcode.stylist;");
        for (String s : generate) {
            System.out.println(generate);
        }
    }

}