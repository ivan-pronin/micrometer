/**
 * Copyright 2017 Pivotal Software, Inc.
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
package org.springframework.metrics.instrument.web;

import java.util.Map;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.metrics.instrument.Tag;

/**
 * @author Jon Schneider
 */
public interface WebMetricsTagProvider {
    /**
     * @param request  RestTemplate client HTTP request
     * @param response may be null in the event of a client error
     * @return a map of tags added to every client HTTP request metric
     */
    Stream<Tag> clientHttpRequestTags(HttpRequest request,
                                      ClientHttpResponse response);

    /**
     * @param request  HTTP request
     * @param response HTTP response
     * @param handler  the request method that is responsible for handling the request
     * @return a map of tags added to every Spring MVC HTTP request metric
     */
    Stream<Tag> httpRequestTags(HttpServletRequest request,
                                HttpServletResponse response, Object handler, String caller);
}
