import {Grid} from "@material-ui/core";
import {withStyles} from "@material-ui/core/styles";
import React from "react";
import BackgroundImageContainer from "../common/BackgroundImageContainer";
import Typography from "@material-ui/core/Typography";

const styles = (theme) => ({

    root: {
        marginTop: theme.spacing(3),
        marginBottom: theme.spacing(14),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },

    h5: {
        marginBottom: theme.spacing(4),
        marginTop: theme.spacing(4),
        [theme.breakpoints.up('sm')]: {
            marginTop: theme.spacing(10),
        },
    },
});

const InternalHero = (props) => {

    const classes = props;

    return (
        <BackgroundImageContainer className={classes.background}>
            <Grid
                container
                spacing={6}
                direction="column"
                justifyContent="center"
                alignItems="center"
            >
                <Grid item>
                    <Typography color="inherit" align="center" variant="h2">
                    Admin Dashboard Of
                    </Typography>
                    <Typography color="inherit" align="center" variant="h2" marked="center" style={{fontWeight: 400}}>
                        EventZen
                    </Typography>
                </Grid>
                <Grid item>
                    <Typography color="inherit" align="center" variant="h5" className={classes.h5}>
                        Built for efficiency, control, and success. Create, Organise and View Events.
                    </Typography>
                </Grid>
            </Grid>
        </BackgroundImageContainer>
    );

}

export default withStyles(styles)(InternalHero);