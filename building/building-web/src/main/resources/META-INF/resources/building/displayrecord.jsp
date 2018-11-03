<%-- 
    Document   : displayrecord
    Created on : 2018.10.25., 15:50:56
    Author     : JUHASZ
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            td{border:solid black 1px;}
        </style>
    </head>
    <body>
        <h1>Display Records</h1>
        <table style="text-align:center;border:solid 1px;width: 80%;">
            <caption><h3>Buildings</h3></caption>
            <tr>
                <th>Building ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Level</th>
                <th>Owner ID</th>
            </tr>
            <%Iterator <String> itr;%>
            <%List<String> data = (List<String>) request.getAttribute("BuildingData");
            for (itr = data.iterator(); itr.hasNext();){
            %>
            <tr>
                <% String s = itr.next();%>
                <td><%=s%></td>
                <td><%= itr.next() %></td>
                <td><%= itr.next() %></td>
                <td><%= itr.next() %></td>
                <td><%= itr.next() %></td>
                
            <%}%>
            </tr>
        </table>
    </body>
</html>
