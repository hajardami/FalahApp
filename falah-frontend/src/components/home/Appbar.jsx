import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import { ThemeProvider } from "@mui/material/styles";
import theme from '../../style/theme';
import falahlogo from '../../res/images/falahlogo.png'
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';
import Typography from '@mui/material/Typography';
import { alpha } from "@mui/material";
import Tooltip from '@mui/material/Tooltip';
import LanguageIcon from '@mui/icons-material/Language';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';

const navItems = ['Home', 'About', 'Services'];
const langages = ['Francais', 'Arabe'];

const Appbar = () => {

    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);

      const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
      };
      const handleClose = () => {
        setAnchorEl(null);
      };

    return (
        <ThemeProvider theme={theme}>
            <AppBar position="sticky" color="neutral" variant ="white">
            <Toolbar sx={{
            display: { xs: "flex" },
            flexDirection: "row",
            justifyContent: "space-between"
          }}>
            <img src={falahlogo} alt="logo" width={"200px"} />
          <Menu
              id="menu-appbar"
              anchorOrigin={{
                vertical: 'bottom',
                horizontal: 'left',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'left',
              }}
              sx={{
                display: { xs: 'block', md: 'none' },
              }}
            >
              {navItems.map((item) => (
                <MenuItem key={item}>
                  <Typography textAlign="center">{item}</Typography>
                </MenuItem>
              ))}
            </Menu>
            <Box sx={{ flexGrow: 1, display: { xs: 'flex', sm: 'block' } }}>
            {navItems.map((item) => (
              <Button key={item} sx={{ m:3, color: '#000', "&:hover": {backgroundColor: alpha("#007155", 0.7), color: "white"}}}>
                {item}
              </Button>
            ))}
            <Button
                id="basic-button"
                aria-controls={open ? 'basic-menu' : undefined}
                aria-haspopup="true"
                aria-expanded={open ? 'true' : undefined}
                onClick={handleClick}
                sx={{ m: 3, color: "black", "&:hover": {backgroundColor: alpha("#007155", 0.7), color: "white"}}}
                startIcon={<LanguageIcon />}
                endIcon={<KeyboardArrowDownIcon />}
            >
                Langue
            </Button>
            <Menu
                id="basic-menu"
                anchorEl={anchorEl}
                open={open}
                onClose={handleClose}
                MenuListProps={{
                    'aria-labelledby': 'basic-button',
            }}
            >
                <MenuItem onClick={handleClose}>Francais</MenuItem>
                <MenuItem onClick={handleClose}>Arabe</MenuItem>
            </Menu>
          </Box>
          <Button href="/signin"variant="outlined" sx={{borderRadius : "20px", "&:hover": {backgroundColor: alpha("#007155", 0.7), color: "white"}}}>Sign In</Button>
            </Toolbar>
        </AppBar>
        </ThemeProvider>
    );
};

export default Appbar;