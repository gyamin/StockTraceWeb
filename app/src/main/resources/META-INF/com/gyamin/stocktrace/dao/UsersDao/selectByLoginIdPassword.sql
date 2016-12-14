select
  /*%expand*/*
from
  users
where
  login_id = /* loginId */'hoge'
  and password = /* password */'password'
