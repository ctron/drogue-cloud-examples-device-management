(this.webpackJsonpwebapp=this.webpackJsonpwebapp||[]).push([[0],{175:function(e,n,t){"use strict";t.r(n);var c=t(0),a=t.n(c),i=t(23),r=t.n(i),o=(t(87),t(88),t(10)),s=t(11),l=t(13),j=t(12),u=(t(89),t(197)),d=t(82),h=t(194),b=t(198),O=t(191),v=t(192),f=t(196),x=t(193),g=t(195),p=t(19),m=function(e){var n=e.devices;return Object(p.jsx)(a.a.Fragment,{children:Object(p.jsxs)(b.a,{children:[Object(p.jsx)(O.a,{children:Object(p.jsx)(v.a,{children:Object(p.jsx)(f.a,{children:"Name"},0)})}),Object(p.jsx)(x.a,{children:n.map((function(e,n){return Object(p.jsx)(v.a,{children:Object(p.jsx)(g.a,{dataLabel:"Name",children:e.id},"{idx}_name")},n)}))})]})})},k=function(e){Object(l.a)(t,e);var n=Object(j.a)(t);function t(){var e;Object(o.a)(this,t);for(var c=arguments.length,a=new Array(c),i=0;i<c;i++)a[i]=arguments[i];return(e=n.call.apply(n,[this].concat(a))).state={devices:[]},e}return Object(s.a)(t,[{key:"componentDidMount",value:function(){var e=this;fetch("/devices").then((function(e){return e.json()})).then((function(n){e.setState({devices:n})})).catch(console.log)}},{key:"loginOk",value:function(e){console.log(e)}},{key:"loginFailed",value:function(e){console.error(e)}},{key:"render",value:function(){var e=null==this.state.token,n=this.state.devices;console.log(e);var t=Object(p.jsx)(u.a,{});return Object(p.jsx)(a.a.Fragment,{children:Object(p.jsx)(d.a,{header:t,children:Object(p.jsx)(h.a,{children:Object(p.jsx)(m,{devices:n})})})})}}]),t}(c.Component),y=function(e){e&&e instanceof Function&&t.e(3).then(t.bind(null,199)).then((function(n){var t=n.getCLS,c=n.getFID,a=n.getFCP,i=n.getLCP,r=n.getTTFB;t(e),c(e),a(e),i(e),r(e)}))};r.a.render(Object(p.jsx)(a.a.StrictMode,{children:Object(p.jsx)(k,{})}),document.getElementById("root")),y()},87:function(e,n,t){},89:function(e,n,t){}},[[175,1,2]]]);
//# sourceMappingURL=main.938bd895.chunk.js.map