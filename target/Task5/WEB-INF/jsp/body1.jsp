<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/24
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--先验证cookie--%>

<html>
<head>
    <meta charset="utf-8">
    <title>职业页面</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="/Task4/other/css/t11.css" rel="stylesheet" type="text/css">
    <link href="/Task4/other/css/base.css" rel="stylesheet" type="text/css">
    <link href="/Task4/other/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="/Task4/other/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="/Task4/other/css/Untitled-1base.css" rel="stylesheet" type="text/css">
</head>

<body>


<div class="container">
    当前用户:${username}<br/>
    <a href="/Task5/logout" >退出登录</a>
    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
        <a class="nav-bar-a" href="">前端开发</a>
        <a class="nav-bar-a" href="">后端开发</a>
        <a class="nav-bar-a" href="">移动开发</a>
        <a class="nav-bar-a" href="">整站开发</a>
        <a class="nav-bar-a" href="">运营维护</a>
    </div>




    <div class="caption">
        <h4>前端开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${majorList}" var="major">
            <c:if test="${major.type==1}">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="/Task4/other/images2/687.png"></div>
                    <div class="text">
                        <h4 class="">${major.major_name}</h4>
                        <p class="text-present">${major.major_intro}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">threshold
                            <c:forEach begin="1" end="${major.threshold}">
                                <img src="/Task4/other/images2/xx.png">
                            </c:forEach>
                        </div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">difficulty
                            <c:forEach begin="1" end="${major.difficulty}">
                                <img src="/Task4/other/images2/xx.png">
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${major.cycle}</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${major.demand}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">${major.y0_1}/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">1-2年</div>
                            <div class="rightWarp-wages">${major.y1_2}/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">2-3年</div>
                            <div class="rightWarp-wages">${major.y2_3}/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${major.learning}人在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:${major.tips}</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">${major.major_name}</p>
                    <p class="flip-text">${major.major_intro_detailed}</p>
                </div>
            </div>
        </div>
            </c:if>
        </c:forEach>
    </div>

            <div class="caption">
                <h4>后端开发方向</h4>
            </div>

    <div class="row">
        <c:forEach items="${majorList}" var="major">
            <c:if test="${major.type==2}">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="/Task4/other/images2/687.png"></div>
                        <div class="text">
                            <h4 class="">${major.major_name}</h4>
                            <p class="text-present">${major.major_intro}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">threshold
                                <c:forEach begin="1" end="${major.threshold}">
                                    <img src="/Task4/other/images2/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">difficulty
                                <c:forEach begin="1" end="${major.difficulty}">
                                    <img src="/Task4/other/images2/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${major.cycle}</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${major.demand}</span>家公司需要</div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${major.y0_1}/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">1-2年</div>
                                <div class="rightWarp-wages">${major.y1_2}/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">2-3年</div>
                                <div class="rightWarp-wages">${major.y2_3}/月</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${major.learning}人在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:${major.tips}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${major.major_name}</p>
                        <p class="flip-text">${major.major_intro_detailed}</p>
                    </div>
                </div>
        </div>
            </c:if>
        </c:forEach>
    </div>

        <div class="caption">
            <h4>移动开发方向</h4>
        </div>

    <div class="row padding-bottom">
        <c:forEach items="${majorList}" var="major">
            <c:if test="${major.type==3}">
                <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                    <div class="warp-border">
                        <div class="clearfix">
                            <div class="icon-people">
                                <img src="/Task4/other/images2/687.png">
                            </div>
                            <div class="text">
                                <h4 class="">${major.major_name}</h4>
                                <p class="text-present">${major.major_intro}</p>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">threshold
                                    <c:forEach begin="1" end="${major.threshold}">
                                        <img src="/Task4/other/images2/xx.png">
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">difficulty
                                    <c:forEach begin="1" end="${major.difficulty}">
                                        <img src="/Task4/other/images2/xx.png">
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${major.cycle}</span>年</div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${major.demand}</span>家公司需要</div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="leftWarp">
                                薪资待遇
                            </div>
                            <div class="rightWarp">
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">0-1年</div>
                                    <div class="rightWarp-wages">${major.y0_1}/月</div>
                                </div>
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">1-2年</div>
                                    <div class="rightWarp-wages">${major.y1_2}/月</div>
                                </div>
                                <div class="rightWarp-class border-bottom">
                                    <div class="rightWarp-year">2-3年</div>
                                    <div class="rightWarp-wages">${major.y2_3}/月</div>
                                </div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <b class="text-b">有${major.learning}人在学</b>
                        </div>
                        <div class="warp-class2">
                            <p class="text-p">提示:${major.tips}</p>
                        </div>

                        <div class="flip-container">
                            <p class="flip-title">${major.major_name}</p>
                            <p class="flip-text">${major.major_intro_detailed}</p>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>

</body>
<script src="/Task4/other/js/jquery.min.js"></script>
<script  src="/Task4/other/js/bootstrap.min.js"></script>
</html>
