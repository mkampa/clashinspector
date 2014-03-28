<html>
<head>
  <title>HTML Analysis</title>
</head>
<body>
<h1>HTML Analysis</h1>

<table border="1">
  <tr>
    <td>clashSeverity</td>
    <td>${(clashSeverity)!}</td>
  </tr>
  <tr>
    <td>testScalar1</td>
    <td>${(testScalar1)!}</td>
  </tr>
  <tr>
    <td>testHash1.header</td>
    <td>${(testHash1.header)!}</td>
  </tr>
  <tr>
    <td>testHash1.root.ort</td>
    <td>${(testHash1.root.ort)!}</td>
  </tr>
  <tr>
    <td>testHash1.root.name</td>
    <td>${(testHash1.root.name)!}</td>
  </tr>
  <tr>
    <td>testHash1.sup()</td>
    <td>${(testHash1.sup())!}</td>
  </tr>

<#list testList1.root as x>
  <tr>
    <td>${x_index + 1}.</td>
    <td>${x} <#if x_has_next>,</#if> </td>
  </tr>
</#list>
<#list testHash1.root?keys as entry>
  <tr>
    <td>${(entry)!} </td>
    <td>${(testHash1.root[entry])!}</td>
  </tr>
</#list>
</table>

</body>
</html>