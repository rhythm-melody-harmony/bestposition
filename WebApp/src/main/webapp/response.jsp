<%@ page language="java" import="com.rmh.webapp.PhraseHandler"%>
<body>
    <jsp:useBean id="mybean" scope="session" class="com.rmh.webapp.PhraseHandler" />
    <jsp:setProperty name="mybean" property="phrase" />
    <h1>This is best position for the given phrase is: <%
    out.print(mybean.run().toString());
    %>
    </h1>
</body>