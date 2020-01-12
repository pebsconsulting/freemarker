/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.freemarker.core.model.impl;

import java.util.Collection;

import org.apache.freemarker.core.model.ObjectWrapper;

/**
 * Whitelist-based member access policy, that is, only members that are matched by the listing will be exposed.
 * Note that {@link DefaultObjectWrapper} and its subclasses doesn't discover all members on the first place, and the
 * {@link MemberAccessPolicy} just removes from that set of members, never adds to it.
 *
 * <p>The whitelist content is usually application specific, and can be significant work to put together, but it's the
 * only way you can achieve any practical safety when you don't fully trust the users who can edit templates.
 *
 * <p>See more about the rules at {@link MemberSelectorListMemberAccessPolicy}.
 * {@link TemplateAccessible} annotation may be used to add members to the whitelist.
 *
 * <p>Of course, this only can deal with the {@link ObjectWrapper} aspect of safety; please check the Manual to see what
 * else is needed. Also, since this is related to security, read the documentation of {@link MemberAccessPolicy}, to
 * know about the pitfalls and edge cases related to {@link MemberAccessPolicy}-es in general.
 */
public class WhitelistMemberAccessPolicy extends MemberSelectorListMemberAccessPolicy {

    /**
     * @param memberSelectors
     *      List of member selectors; see {@link MemberSelectorListMemberAccessPolicy} class-level documentation for
     *      more.
     */
    public WhitelistMemberAccessPolicy(Collection<? extends MemberSelector> memberSelectors) {
        super(memberSelectors, ListType.WHITELIST, TemplateAccessible.class);
    }

}