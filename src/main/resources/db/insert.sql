set foreign_key_checks=0;

truncate table product;
truncate table feedback;

insert into product(`id`, `name`, `price`, `details`, `currency`)
values(110, 'luxury chair', 4500, 'wings shield kinda sofa', 'NGN'),
(111, 'luxury sofa', 4500, 'wings shield kinda sofa', 'USD'),
(112, 'luxury bed', 6500, 'wings shield kinda sofa', 'GBP'),
(113, 'luxury table', 9500, 'wings shield kinda sofa', 'NGN');

set foreign_key_checks=1;