select
  /*%expand*/*
from
  stock_prices
where
  trade_date = /* tradeDate */'2010-01-23'
  and
  issue_code = /* issueCode */1
