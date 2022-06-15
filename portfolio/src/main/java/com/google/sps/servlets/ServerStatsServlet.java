// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.util.*;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/server-stats")
public final class ServerStatsServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Calculate server stats
    ArrayList<String> list = new ArrayList<String>();
    list.add("Movie (Romance/Family Drama): Kabhi Khushi Kabhi Gham");
    list.add("Movie (Romance/Family Drama): Kuch Kuch Hota Hai");
    list.add("TV Show (Comedy/Sitcom): Brooklyn 99");
    list.add("TV Show (Comedy/Sitcom): Friends");
    list.add("TV Show (Comedy/Sitcom): New Girl");

    // Convert the server stats to JSON
    Gson gson = new Gson();
    String json = gson.toJson(list);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
    
  }
}

