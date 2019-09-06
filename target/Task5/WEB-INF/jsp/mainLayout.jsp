<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/26
  主布局页面,由header,item,footer组成
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<div>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="item"/>
    <tiles:insertAttribute name="footer" />
</div>
