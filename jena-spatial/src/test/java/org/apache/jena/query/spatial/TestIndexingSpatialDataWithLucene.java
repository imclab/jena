/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.query.spatial;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.jena.atlas.lib.StrUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIndexingSpatialDataWithLucene extends
		AbstractTestIndexingSpatialData {
	private static final String INDEX_PATH = "target/test/IsNearByPFWithLuceneSpatialIndex";
	private static final File INDEX_DIR = new File(INDEX_PATH);

	@Before
	public void init() throws IOException {
		dataset = SpatialSearchUtil
				.initInMemoryDatasetWithLuceneSpatitalIndex(INDEX_DIR);

		SpatialIndex index = (SpatialIndex) dataset.getContext().get(
				SpatialQuery.spatialIndex);
		index.getDocDef().setSpatialContextFactory(
				"com.spatial4j.core.context.jts.JtsSpatialContextFactory");

	}

	@After
	public void destroy() {
		SpatialSearchUtil.deleteOldFiles(INDEX_DIR);
	}

}
