<#include "common.ftl" >
  <script type="text/javascript">
    alert('${errorMsg}');
<<<<<<< HEAD
    <#--window.location.href="${ctx}/index";-->
    if('${uri}'.indexOf("/main")>-1){
=======
    if('${uri}'=="/main"){
>>>>>>> f6ce3391221933bbaf5f13abf6f88ca4a4e5b78d
    	window.location.href="${ctx}/index";
    }else{
    	window.parent.location.href="${ctx}/index";
    }
    
  </script>
