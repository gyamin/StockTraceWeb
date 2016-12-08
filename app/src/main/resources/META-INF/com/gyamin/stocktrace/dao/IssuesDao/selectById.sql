select
  /*%expand*/*
from
  issues
where
  section = /* section */'a'
  and
  issue_code = /* issueCode */1
