# leetcode_code

## Leetcode Editor Setting
TempFilePath
```
MyLeetcode\src
```

File Name
```
$!velocityTool.camelCaseName(${question.titleSlug})
```

Code Template
```
package leetcode.editor.cn;
// [${question.frontendQuestionId}] ${question.title}
// $!velocityTool.date()

public class $!velocityTool.camelCaseName(${question.titleSlug}) {
  int id = ${question.frontendQuestionId};
  
  public static void main(String[] args) {
      Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
  }
  
${question.code}
}
```
