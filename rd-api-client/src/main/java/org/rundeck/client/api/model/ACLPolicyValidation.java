/*
 * Copyright 2017 Rundeck, Inc. (http://rundeck.com)
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

package org.rundeck.client.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ACLPolicyValidation extends ErrorResponse {
    public boolean valid;
    public List<ValidationError> policies;

    public Map<String, Object> toMap() {
        if (null == policies || policies.size() < 1) {
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        policies.forEach(err -> result.put(err.policy, err.errors));
        return result;

    }

    public static class ValidationError {
        public String policy;
        public List<String> errors;
    }

}
