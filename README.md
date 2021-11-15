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

public class $!velocityTool.camelCaseName(${question.titleSlug}){
  public static void main(String[] args) {
      Solution solution = new Solution();
  }
}

${question.code}
```