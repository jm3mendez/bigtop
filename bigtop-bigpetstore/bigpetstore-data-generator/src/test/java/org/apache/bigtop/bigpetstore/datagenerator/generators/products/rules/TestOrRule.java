/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.bigtop.bigpetstore.datagenerator.generators.products.rules;

import org.junit.Assert;
import org.junit.Test;

public class TestOrRule
{

	@Test
	public void testRuleMatches()
	{
		Rule rule = new OrRule(
				new AlwaysTrueRule(),
				new AlwaysTrueRule());
		Assert.assertTrue(rule.ruleMatches(null));
		
		rule = new OrRule(
				new AlwaysTrueRule(),
				new NotRule(
						new AlwaysTrueRule()));
		Assert.assertTrue(rule.ruleMatches(null));
		
		rule = new OrRule(
				new NotRule(
						new AlwaysTrueRule()),
				new AlwaysTrueRule());
		Assert.assertTrue(rule.ruleMatches(null));
		
		rule = new OrRule(
				new NotRule(
						new AlwaysTrueRule()),
				new NotRule(
						new AlwaysTrueRule()));
		Assert.assertFalse(rule.ruleMatches(null));
	}
}
